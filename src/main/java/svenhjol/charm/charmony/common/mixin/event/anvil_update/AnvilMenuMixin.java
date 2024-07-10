package svenhjol.charm.charmony.common.mixin.event.anvil_update;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import svenhjol.charm.charmony.Resolve;
import svenhjol.charm.charmony.event.AnvilUpdateEvent;
import svenhjol.charm.feature.core.Core;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {
    @Shadow @Final private DataSlot cost;

    @Shadow private int repairItemCountCost;

    public AnvilMenuMixin(@Nullable MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess access) {
        super(menuType, i, inventory, access);
    }

    @Inject(
        method = "createResult",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z",
            ordinal = 1,
            shift = At.Shift.BEFORE
        ),
        cancellable = true,
        locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void hookCreateResult(CallbackInfo ci, ItemStack input, int i, long baseCost, int j, ItemStack itemStack2, ItemStack material, ItemEnchantments.Mutable mutable) {
        var result = AnvilUpdateEvent.INSTANCE.invoke(player, input, material, baseCost);
        if (result.isPresent()) {
            var recipe = result.get();
            resultSlots.setItem(0, recipe.output);
            cost.set(recipe.experienceCost);
            this.repairItemCountCost = recipe.materialCost;
            ci.cancel();
        }
    }

    @Redirect(
        method = "onTake",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/Container;setItem(ILnet/minecraft/world/item/ItemStack;)V"
        )
    )
    private void hookOnTakeSetItem(Container inputSlots, int slot, ItemStack stack) {
        if (Resolve.feature(Core.class).customOnTakeBehavior() && stack == ItemStack.EMPTY) {
            var original = inputSlots.getItem(slot);
            original.shrink(1);
            inputSlots.setItem(slot, original);
        }
    }
}
