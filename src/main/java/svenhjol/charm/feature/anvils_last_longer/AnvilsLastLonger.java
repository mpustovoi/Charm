package svenhjol.charm.feature.anvils_last_longer;

import net.minecraft.util.Mth;
import svenhjol.charm.feature.anvils_last_longer.common.Handlers;
import svenhjol.charm.foundation.annotation.Configurable;
import svenhjol.charm.foundation.annotation.Feature;
import svenhjol.charm.foundation.common.CommonFeature;
import svenhjol.charm.foundation.common.CommonLoader;

@Feature(description = "Anvils are less likely to take damage when used. By default anvils are 50% stronger.")
public class AnvilsLastLonger extends CommonFeature {
    public final Handlers handlers;

    @Configurable(
        name = "Damage chance",
        description = """
            Chance (out of 1.0) of an anvil applying the damage it would normally receive.
            A value of 0.0 makes anvils invulnerable and a value of 1.0 is vanilla damage behavior."""
    )
    private static double chanceToDamage = 0.5d;

    public double chanceToDamage() {
        return Mth.clamp(chanceToDamage, 0.0d, 1.0d);
    }

    public AnvilsLastLonger(CommonLoader loader) {
        super(loader);

        handlers = new Handlers(this);
    }
}