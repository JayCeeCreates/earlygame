package jayceecreates.earlygame.utils;

import java.util.Random;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.lwjgl.system.NonnullDefault;

import jayceecreates.earlygame.EarlyGame;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class ModShapelessRecipe extends ShapelessRecipe {

    private final DefaultedList<Ingredient> inputs;
    private final ItemStack output;

    private ModShapelessRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> input) {
        super(id, group, output, input);
        this.inputs = input;
        this.output = output;
    }

    @Override
    public ItemStack craft(CraftingInventory inv) {
       return this.output.copy();
    }

    @Override
    public boolean matches(CraftingInventory inv, World world) {
        RecipeFinder recipeFinder = new RecipeFinder();
        int i = 0;
  
        for(int j = 0; j < inv.size(); ++j) {
           ItemStack itemStack = inv.getStack(j);
           if (!itemStack.isEmpty()) {
              ++i;
              recipeFinder.method_20478(itemStack, 1);
           }
        }
  
        return i == this.inputs.size() && recipeFinder.findRecipe(this, null);
    }

    @Override
    @NonnullDefault
    public DefaultedList<ItemStack> getRemainingStacks(CraftingInventory inv) {

        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inv.size(), ItemStack.EMPTY);

        for (int i = 0; i < defaultedList.size(); ++i) {

            ItemStack stack = inv.getStack(i);

            if (stack.isEmpty()) continue;

            if (stack.getItem().isDamageable()) {
                    
                ItemStack savedStack = stack.copy();
                boolean shouldAttemptDmg = true;
                Random random = new Random();
                int unbreakingLvl = EnchantmentHelper.getLevel(Enchantments.UNBREAKING, savedStack);

                if (unbreakingLvl > 0) shouldAttemptDmg = (1 + random.nextInt(5)) <= unbreakingLvl;

                if (savedStack.getDamage() < savedStack.getMaxDamage()) {

                    if (shouldAttemptDmg) savedStack.setDamage(savedStack.getDamage() + 1);

                    defaultedList.set(i, savedStack);

                }
                else defaultedList.set(i, ItemStack.EMPTY);

            }
        }
        return defaultedList;
    }

    @Override
    @NonnullDefault
    public RecipeSerializer<?> getSerializer()
    {
        return EarlyGame.SHAPELESS_RECIPE;
    }
    
    public static class Serializer implements RecipeSerializer<ModShapelessRecipe> {
        @Override
        public ModShapelessRecipe read(Identifier id, JsonObject json) {
            String s = JsonHelper.getString(json, "group", "");
            DefaultedList<Ingredient> defaultedList = readIngredients(JsonHelper.getArray(json, "ingredients"));
            if (defaultedList.isEmpty()) {
                throw new JsonParseException("No ingredients for EarlyGame shapeless recipe");
            }
            ItemStack stack = ShapedRecipe.getItemStack(JsonHelper.getObject(json, "result"));
            return new ModShapelessRecipe(id, s, stack, defaultedList);
        }

        private static DefaultedList<Ingredient> readIngredients(JsonArray jsonArray)
        {
            DefaultedList<Ingredient> defaultedList = DefaultedList.of();
            for (int i = 0; i < jsonArray.size(); i++) {
                Ingredient ingr = Ingredient.fromJson(jsonArray.get(i));
                if (!ingr.isEmpty()) {
                    defaultedList.add(ingr);
                }
            }
            return defaultedList;
        }

        @Override
        public ModShapelessRecipe read(Identifier id, PacketByteBuf buffer)
        {
            String s = buffer.readString(32767);
            int i = buffer.readVarInt();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);

            for (int j = 0; j < defaultedList.size(); ++j) {
                defaultedList.set(j, Ingredient.fromPacket(buffer));
            }

            ItemStack stack = buffer.readItemStack();
            return new ModShapelessRecipe(id, s, stack, defaultedList);
        }

        @Override
        public void write(PacketByteBuf buffer, ModShapelessRecipe recipe)
        {
            buffer.writeString(recipe.getGroup());
            buffer.writeVarInt(recipe.inputs.size());

            for (Ingredient ingredient : recipe.inputs)
            {
                ingredient.write(buffer);
            }

            buffer.writeItemStack(recipe.output);
        }
    }
}
