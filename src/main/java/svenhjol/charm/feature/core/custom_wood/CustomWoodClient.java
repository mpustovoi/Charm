package svenhjol.charm.feature.core.custom_wood;

import svenhjol.charm.feature.core.CoreClient;
import svenhjol.charm.feature.core.custom_wood.client.Handlers;
import svenhjol.charm.feature.core.custom_wood.client.Registers;
import svenhjol.charm.foundation.annotation.Feature;
import svenhjol.charm.foundation.client.ClientFeature;
import svenhjol.charm.foundation.client.ClientLoader;
import svenhjol.charm.foundation.common.CommonResolver;
import svenhjol.charm.foundation.feature.SubFeature;

@Feature(priority = -10)
public final class CustomWoodClient extends ClientFeature implements SubFeature<CoreClient>, CommonResolver<CustomWood> {
    public final Registers registers;
    public final Handlers handlers;

    public CustomWoodClient(ClientLoader loader) {
        super(loader);

        registers = new Registers(this);
        handlers = new Handlers(this);
    }

    @Override
    public Class<CustomWood> typeForCommon() {
        return CustomWood.class;
    }

    @Override
    public Class<CoreClient> typeForParent() {
        return CoreClient.class;
    }
}