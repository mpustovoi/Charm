package svenhjol.charm.feature.core.custom_wood.types;

import net.minecraft.world.level.block.entity.BlockEntityType;
import svenhjol.charm.feature.core.custom_wood.common.CustomType;
import svenhjol.charm.feature.core.custom_wood.common.CustomWoodHolder;
import svenhjol.charm.foundation.block.CharmStandingSignBlock;
import svenhjol.charm.foundation.block.CharmWallSignBlock;
import svenhjol.charm.foundation.item.CharmSignItem;

import java.util.List;
import java.util.function.Supplier;

public class CustomSign {
    public final Supplier<CharmStandingSignBlock> standingBlock;
    public final Supplier<CharmWallSignBlock> wallBlock;
    public final Supplier<CharmSignItem> item;

    public CustomSign(CustomWoodHolder holder) {
        var registry = holder.ownerRegistry();
        var material = holder.getMaterial();
        var woodType = holder.woodType();

        var signId = holder.getMaterialName() + "_sign";
        var wallSignId = holder.getMaterialName() + "_wall_sign";

        standingBlock = registry.block(signId, () -> new CharmStandingSignBlock(material, woodType));
        wallBlock = registry.wallSignBlock(wallSignId, material, standingBlock, woodType);
        item = registry.item(signId, () -> new CharmSignItem(material, standingBlock, wallBlock));

        // This is needed so we can set the correct blocks to signs later on in the registration.
        holder.feature().registers.addSignItem(item);

        // Associate with the sign block entity.
        registry.blockEntityBlocks(() -> BlockEntityType.SIGN, List.of(standingBlock, wallBlock));

        holder.addCreativeTabItem(CustomType.SIGN, item);
    }
}
