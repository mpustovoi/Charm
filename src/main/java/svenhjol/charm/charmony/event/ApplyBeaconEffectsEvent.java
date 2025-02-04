package svenhjol.charm.charmony.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class ApplyBeaconEffectsEvent extends CharmEvent<ApplyBeaconEffectsEvent.Handler> {
    public static final ApplyBeaconEffectsEvent INSTANCE = new ApplyBeaconEffectsEvent();

    private ApplyBeaconEffectsEvent() {}

    public void invoke(Level level, BlockPos pos, int beaconLevel,
                       @Nullable Holder<MobEffect> primary, @Nullable Holder<MobEffect> secondary) {
        for (var handler : getHandlers()) {
            handler.run(level, pos, beaconLevel, primary, secondary);
        }
    }

    @FunctionalInterface
    public interface Handler {
        void run(Level level, BlockPos pos, int beaconLevel,
                 @Nullable Holder<MobEffect> primary, @Nullable Holder<MobEffect> secondary);
    }
}
