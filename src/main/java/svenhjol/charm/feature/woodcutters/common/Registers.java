package svenhjol.charm.feature.woodcutters.common;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import svenhjol.charm.feature.woodcutters.Woodcutters;
import svenhjol.charm.foundation.feature.RegisterHolder;

import java.util.function.Supplier;

public final class Registers extends RegisterHolder<Woodcutters> {
    public static final String BLOCK_ID = "woodcutter";

    public final Supplier<Block> block;
    public final Supplier<Block.BlockItem> blockItem;
    public final Supplier<MenuType<Menu>> menu;
    public final Supplier<PoiType> poiType;
    public final Supplier<SoundEvent> useSound;
    public final Supplier<RecipeBookType> recipeBookType;

    public Registers(Woodcutters feature) {
        super(feature);
        var registry = feature.registry();

        // Register enum early.
        feature.registry().recipeBookTypeEnum("woodcutter");

        block = registry.block(BLOCK_ID,
            () -> new Block(feature));

        blockItem = registry.item(BLOCK_ID,
            () -> new Block.BlockItem(block));

        poiType = registry.pointOfInterestType(BLOCK_ID,
            () -> new PoiType(ImmutableSet.copyOf(block.get().getStateDefinition().getPossibleStates()),
                1, 1));

        recipeBookType = registry.recipeBookType(BLOCK_ID);

        menu = registry.menuType(BLOCK_ID,
            () -> new MenuType<>(Menu::new, FeatureFlags.VANILLA_SET));

        useSound = registry.soundEvent("woodcutter_use");
    }
}