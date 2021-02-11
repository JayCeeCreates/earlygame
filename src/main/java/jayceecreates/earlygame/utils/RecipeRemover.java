package jayceecreates.earlygame.utils;

import java.util.Map;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableMap;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import jayceecreates.earlygame.EarlyGame;
import jayceecreates.earlygame.EarlyGameClient;
import jayceecreates.earlygame.mixin.RecipeFieldAccessor;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class RecipeRemover {

    public static void removeRecipe() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            final RecipeManager mgr = server.getRecipeManager();

            if (!EarlyGameClient.CONFIG.crafting.enableWoodenTools) {
                removeRecipes(mgr, new ItemStack(Items.WOODEN_AXE));
                removeRecipes(mgr, new ItemStack(Items.WOODEN_HOE));
                removeRecipes(mgr, new ItemStack(Items.WOODEN_PICKAXE));
                removeRecipes(mgr, new ItemStack(Items.WOODEN_SHOVEL));
                removeRecipes(mgr, new ItemStack(Items.WOODEN_SWORD));
            }
            if (!EarlyGameClient.CONFIG.crafting.enableStoneTools) {
                removeRecipes(mgr, new ItemStack(Items.STONE_AXE));
                removeRecipes(mgr, new ItemStack(Items.STONE_HOE));
                removeRecipes(mgr, new ItemStack(Items.STONE_PICKAXE));
                removeRecipes(mgr, new ItemStack(Items.STONE_SHOVEL));
                removeRecipes(mgr, new ItemStack(Items.STONE_SWORD));
            }
            if (!EarlyGameClient.CONFIG.crafting.enablePlanksAndSticks) {
                removeRecipes(mgr, ItemTags.PLANKS);
                removeRecipes(mgr, new ItemStack(Items.STICK, 4));
            }
        });
    }

    // Code below was made by Choonster@github (https://bit.ly/2BLB9t3)
    // Modified by me to make it Fabric-compatible

    /**
     * Removes all crafting recipes with an output item contained in the specified
     * tag.
     *
     * @param recipeManager The recipe manager
     * @param stack         The ItemStack output of the recipe to remove
     */
    private static void removeRecipes(final RecipeManager recipeManager, final ItemStack stack) {
        final int recipesRemoved = removeRecipes(recipeManager, recipe -> {
            final ItemStack recipeOutput = recipe.getOutput();
            return !recipeOutput.isEmpty() && (!stack.isEmpty() && recipeOutput.getCount() == stack.getCount() && recipeOutput.getItem() == stack.getItem() &&ItemStack.areTagsEqual(recipeOutput, stack));
        });

        EarlyGame.LOGGER.info("Removed {} recipe(s)", recipesRemoved);
    }

    /**
     * Removes all crafting recipes with an output item contained in the specified
     * tag.
     *
     * @param recipeManager The recipe manager
     * @param tag           The tag
     */
    private static void removeRecipes(final RecipeManager recipeManager, final Tag<Item> tag) {
        final int recipesRemoved = removeRecipes(recipeManager, recipe -> {
            final ItemStack recipeOutput = recipe.getOutput();
            return !recipeOutput.isEmpty() && recipeOutput.getItem().isIn(tag);
        });

        EarlyGame.LOGGER.info("Removed {} recipe(s)", recipesRemoved);
    }

    /**
     * Remove all crafting recipes that match the specified predicate.
     *
     * @param recipeManager The recipe manager
     * @param predicate     The predicate
     * @return The number of recipes removed
     */
    private static int removeRecipes(final RecipeManager recipeManager, final Predicate<Recipe<?>> predicate) {
        
        final Map<RecipeType<?>, Map<Identifier, Recipe<?>>> existingRecipes;

        final Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipesMap = ((RecipeFieldAccessor) recipeManager).getRecipeField();
        existingRecipes = recipesMap;

        final Object2IntMap<RecipeType<?>> removedCounts = new Object2IntOpenHashMap<>();
        final ImmutableMap.Builder<RecipeType<?>, Map<Identifier, Recipe<?>>> newRecipes = ImmutableMap
                .builder();

        // For each recipe type, create a new map that doesn't contain the recipes to be removed
        existingRecipes.forEach((recipeType, existingRecipesForType) -> {
            // noinspection UnstableApiUsage

            final ImmutableMap<Identifier, Recipe<?>> newRecipesForType = existingRecipesForType.entrySet()
                    .stream().filter(entry -> !predicate.test(entry.getValue()))
                    .collect(ImmutableMap.toImmutableMap(Map.Entry::getKey, Map.Entry::getValue));

            removedCounts.put(recipeType, existingRecipesForType.size() - newRecipesForType.size());
            newRecipes.put(recipeType, newRecipesForType);
        });

        final int removedCount = removedCounts.values().stream().reduce(0, Integer::sum);

        ((RecipeFieldAccessor) recipeManager).setRecipeField(newRecipes.build());

        return removedCount;
    }
}
