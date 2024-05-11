package svenhjol.charm.feature.custom_wood.common;

import svenhjol.charm.foundation.block.CharmLeavesBlock;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class CustomLeaves {
    public final Supplier<CharmLeavesBlock> block;
    public final Supplier<CharmLeavesBlock.BlockItem> item;

    public CustomLeaves(CustomWoodHolder holder) {
        var id = holder.getMaterialName() + "_leaves";
        block = holder.ownerRegistry().block(id, () -> new CharmLeavesBlock(holder.getMaterial()));
        item = holder.ownerRegistry().item(id, () -> new CharmLeavesBlock.BlockItem(block));

        holder.ownerRegistry().ignite(block); // Leaves can set on fire.
        holder.addCreativeTabItem(CustomWoodHelper.LEAVES, item);
    }
}