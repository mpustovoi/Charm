package svenhjol.charm.integration.rei;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;

import java.util.List;

/**
 * See me.shedaniel.rei.plugin.client.categories.DefaultStoneCuttingCategory
 * for reference implementation.
 */
public class WoodcuttingCategory implements DisplayCategory<WoodcuttingDisplay> {
    @Override
    public CategoryIdentifier<? extends WoodcuttingDisplay> getCategoryIdentifier() {
        return Definitions.WOODCUTTING;
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(Definitions.woodcutters().registers.block.get());
    }

    @Override
    public Component getTitle() {
        return Component.translatable("category.rei.charm.woodcutting");
    }

    @Override
    public List<Widget> setupDisplay(WoodcuttingDisplay display, Rectangle bounds) {
        var startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = Lists.newArrayList();

        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5))
            .entries(display.getOutputEntries().getFirst())
            .disableBackground()
            .markOutput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5))
            .entries(display.getInputEntries().getFirst()).markInput());

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }
}