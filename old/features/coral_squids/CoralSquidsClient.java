package svenhjol.charm.feature.coral_squids;

import net.minecraft.client.model.geom.ModelLayerLocation;
import svenhjol.charm.foundation.Feature;
import svenhjol.charm.foundation.feature.Register;
import svenhjol.charm.foundation.client.ClientFeature;
import svenhjol.charm.foundation.common.CommonFeature;

import java.util.Optional;
import java.util.function.Supplier;

public class CoralSquidsClient extends ClientFeature {
    static Supplier<ModelLayerLocation> layer;

    @Override
    public Class<? extends CommonFeature> relatedCommonFeature() {
        return CoralSquids.class;
    }

    @Override
    public Optional<Register<? extends Feature>> registration() {
        return Optional.of(new ClientRegistration(this));
    }
}