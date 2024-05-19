package svenhjol.charm.feature.wood.azalea_wood;

import svenhjol.charm.feature.wood.WoodClient;
import svenhjol.charm.feature.wood.azalea_wood.client.Registers;
import svenhjol.charm.foundation.annotation.Feature;
import svenhjol.charm.foundation.client.ClientFeature;
import svenhjol.charm.foundation.client.ClientLoader;
import svenhjol.charm.foundation.common.CommonResolver;
import svenhjol.charm.foundation.feature.ChildFeature;

@Feature
public final class AzaleaWoodClient extends ClientFeature implements ChildFeature<WoodClient>, CommonResolver<AzaleaWood> {
    public final Registers registers;

    public AzaleaWoodClient(ClientLoader loader) {
        super(loader);

        registers = new Registers(this);
    }

    @Override
    public Class<AzaleaWood> typeForCommon() {
        return AzaleaWood.class;
    }

    @Override
    public Class<WoodClient> typeForParent() {
        return WoodClient.class;
    }
}