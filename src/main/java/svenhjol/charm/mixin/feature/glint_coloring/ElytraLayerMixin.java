package svenhjol.charm.mixin.feature.glint_coloring;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import svenhjol.charm.charmony.Resolve;
import svenhjol.charm.feature.glint_coloring.GlintColoringClient;

@Mixin(ElytraLayer.class)
public class ElytraLayerMixin<T extends LivingEntity> {
    /**
     * Fetches the entity's elytra so that the colored glint handler can modify its color.
     * Makes no runtime modification to this class.
     */
    @Inject(
        method = "render*",
        at = @At("HEAD")
    )
    private void hookRender(PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        Resolve.feature(GlintColoringClient.class).handlers.setTargetStack(livingEntity.getItemBySlot(EquipmentSlot.CHEST));
    }
}
