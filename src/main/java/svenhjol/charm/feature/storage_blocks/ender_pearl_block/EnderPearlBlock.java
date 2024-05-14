package svenhjol.charm.feature.storage_blocks.ender_pearl_block;

import svenhjol.charm.feature.storage_blocks.StorageBlocks;
import svenhjol.charm.feature.storage_blocks.ender_pearl_block.common.Advancements;
import svenhjol.charm.feature.storage_blocks.ender_pearl_block.common.Handlers;
import svenhjol.charm.feature.storage_blocks.ender_pearl_block.common.Registers;
import svenhjol.charm.foundation.annotation.Configurable;
import svenhjol.charm.foundation.annotation.Feature;
import svenhjol.charm.foundation.common.CommonFeature;
import svenhjol.charm.foundation.common.CommonLoader;
import svenhjol.charm.foundation.feature.SubFeature;

@Feature(description = "Combine ender pearls to make an ender pearl block.")
public final class EnderPearlBlock extends CommonFeature implements SubFeature<StorageBlocks> {
    public final Advancements advancements;
    public final Handlers handlers;
    public final Registers registers;

    @Configurable(
        name = "Ender pearl block converts silverfish",
        description = "If true, ender pearl blocks will convert silverfish to endermites."
    )
    public static boolean convertSilverfish = true;

    public EnderPearlBlock(CommonLoader loader) {
        super(loader);

        registers = new Registers(this);
        handlers = new Handlers(this);
        advancements = new Advancements(this);
    }

    @Override
    public Class<StorageBlocks> typeForParent() {
        return StorageBlocks.class;
    }
}