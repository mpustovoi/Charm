package svenhjol.charm;

import svenhjol.charm.feature.arcane_purpur.ArcanePurpurClient;
import svenhjol.charm.feature.atlases.AtlasesClient;
import svenhjol.charm.feature.azalea_wood.AzaleaWoodClient;
import svenhjol.charm.feature.bat_buckets.BatBucketsClient;
import svenhjol.charm.feature.chairs.ChairsClient;
import svenhjol.charm.feature.clear_item_frames.ClearItemFramesClient;
import svenhjol.charm.feature.colored_glint_templates.ColoredGlintTemplatesClient;
import svenhjol.charm.feature.colored_glints.ColoredGlintsClient;
import svenhjol.charm.feature.copper_pistons.CopperPistonsClient;
import svenhjol.charm.feature.coral_squids.CoralSquidsClient;
import svenhjol.charm.feature.custom_wood.CustomWoodClient;
import svenhjol.charm.feature.extra_tooltips.ExtraTooltips;
import svenhjol.charm.feature.extractable_enchantments.ExtractableEnchantmentsClient;
import svenhjol.charm.feature.hover_sorting.HoverSortingClient;
import svenhjol.charm.feature.inventory_tidying.InventoryTidyingClient;
import svenhjol.charm.feature.kilns.KilnsClient;
import svenhjol.charm.feature.show_repair_cost.ShowRepairCost;
import svenhjol.charm.feature.smooth_glowstone.SmoothGlowstoneClient;
import svenhjol.charm.feature.storage_blocks.StorageBlocksClient;
import svenhjol.charm.feature.totem_of_preserving.TotemOfPreservingClient;
import svenhjol.charm.feature.variant_mob_textures.VariantMobTextures;
import svenhjol.charm.feature.variant_wood.VariantWoodClient;
import svenhjol.charm.feature.woodcutters.WoodcuttersClient;
import svenhjol.charm.foundation.client.ClientFeature;

import java.util.List;

public final class CharmClient {
    public static List<Class<? extends ClientFeature>> features() {
        return List.of(
            ArcanePurpurClient.class,
            AtlasesClient.class,
            AzaleaWoodClient.class,
            BatBucketsClient.class,
            ChairsClient.class,
            ClearItemFramesClient.class,
            ColoredGlintTemplatesClient.class,
            ColoredGlintsClient.class,
            CopperPistonsClient.class,
            CoralSquidsClient.class,
            CustomWoodClient.class,
            ExtraTooltips.class,
            ExtractableEnchantmentsClient.class,
            HoverSortingClient.class,
            InventoryTidyingClient.class,
            KilnsClient.class,
            ShowRepairCost.class,
            SmoothGlowstoneClient.class,
            StorageBlocksClient.class,
            TotemOfPreservingClient.class,
            VariantMobTextures.class,
            VariantWoodClient.class,
            WoodcuttersClient.class
        );
    }
}
