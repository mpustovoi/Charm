package svenhjol.charm.feature.azalea_wood.common;

import svenhjol.charm.api.iface.IConditionalRecipe;
import svenhjol.charm.api.iface.IConditionalRecipeProvider;
import svenhjol.charm.feature.woodcutting.Woodcutting;
import svenhjol.charm.foundation.Resolve;

import java.util.List;

public final class DataProviders implements IConditionalRecipeProvider {
    @Override
    public List<IConditionalRecipe> getRecipeConditions() {
        return List.of(
            new IConditionalRecipe() {
                @Override
                public boolean test() {
                    return Resolve.featureEnabled(Woodcutting.class);
                }

                @Override
                public List<String> recipes() {
                    return List.of("azalea_wood/woodcutting/*");
                }
            }
        );
    }
}