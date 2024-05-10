package svenhjol.charm.feature.woodcutting;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import svenhjol.charm.foundation.Resolve;

@SuppressWarnings("unused")
public class WoodcuttingRecipe extends SingleItemRecipe {
   private static final Woodcutting FEATURE = Resolve.feature(Woodcutting.class);
   public Item icon = Items.AIR;

   public WoodcuttingRecipe(String group, Ingredient input, ItemStack output) {
      super(FEATURE.registers.recipeType.get(), FEATURE.registers.recipeSerializer.get(), group, input, output);
   }

   public Ingredient getInput() {
      return this.ingredient;
   }

   public ItemStack getResultItem() {
      return this.result.copy();
   }

   public ItemStack getRecipeKindIcon() {
      return new ItemStack(icon);
   }

   @Override
   public boolean matches(SingleRecipeInput recipeInput, Level level) {
      return this.ingredient.test(recipeInput.item());
   }
}
