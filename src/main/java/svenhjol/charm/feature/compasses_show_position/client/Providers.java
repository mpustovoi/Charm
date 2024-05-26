package svenhjol.charm.feature.compasses_show_position.client;

import svenhjol.charm.api.iface.CompassOverlayItem;
import svenhjol.charm.api.iface.CompassOverlayProvider;
import svenhjol.charm.feature.compasses_show_position.CompassesShowPosition;
import svenhjol.charm.foundation.Api;
import svenhjol.charm.foundation.feature.ProviderHolder;

import java.util.ArrayList;
import java.util.List;

public final class Providers extends ProviderHolder<CompassesShowPosition> {
    public final List<CompassOverlayItem> overlayItems = new ArrayList<>();

    public Providers(CompassesShowPosition feature) {
        super(feature);
    }

    @Override
    public void onEnabled() {
        Api.consume(CompassOverlayProvider.class,
            provider -> overlayItems.addAll(provider.getCompassOverlayItems()));
    }
}