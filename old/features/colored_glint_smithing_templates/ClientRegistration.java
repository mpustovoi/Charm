package svenhjol.charm.feature.colored_glint_smithing_templates;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import svenhjol.charm.foundation.feature.Register;

public final class ClientRegistration extends Register<ColoredGlintSmithingTemplatesClient> {
    public ClientRegistration(ColoredGlintSmithingTemplatesClient feature) {
        super(feature);
    }

    @Override
    public void onEnabled() {
        feature.registry().itemTab(
            ColoredGlintSmithingTemplates.item,
            CreativeModeTabs.INGREDIENTS,
            Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE
        );
    }
}