package svenhjol.charm.feature.woodcutting;

import svenhjol.charm.feature.woodcutting.common.Registers;
import svenhjol.charm.foundation.annotation.Feature;
import svenhjol.charm.foundation.common.CommonFeature;
import svenhjol.charm.foundation.common.CommonLoader;

@Feature(canBeDisabled = false, description = "Registers the woodcutting recipe.")
public class Woodcutting extends CommonFeature {
    public final Registers registers;

    public Woodcutting(CommonLoader loader) {
        super(loader);

        registers = new Registers(this);
    }
}
