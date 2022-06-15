package jayceecreates.earlygame.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

@Mixin(Ingredient.class)
public abstract class IngredientMixin implements MatchingStackAccessor {

    @Shadow protected abstract void cacheMatchingStacks();

    @Shadow private ItemStack[] matchingStacks;

    @Override
    public ItemStack[] getMatchingStacks() {
        cacheMatchingStacks();
        return matchingStacks;
    }
}