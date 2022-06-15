package jayceecreates.earlygame.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

@Mixin(Ingredient.class)
public interface MatchingStackAccessor {
    @Accessor("matchingStacks")
    ItemStack[] getMatchingStacks();
}
