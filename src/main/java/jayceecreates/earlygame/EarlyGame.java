package jayceecreates.earlygame;

import jayceecreates.earlygame.init.*;
import jayceecreates.earlygame.utils.DisableWoodStoneTools;
import jayceecreates.earlygame.utils.FlintKnapEvent;
import jayceecreates.earlygame.utils.ModShapelessRecipe;
// import jayceecreates.earlygame.utils.RequiredTool;
import jayceecreates.earlygame.world.CopperOreGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EarlyGame implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("EarlyGame");

    public static final RecipeSerializer<ModShapelessRecipe> SHAPELESS_RECIPE = new ModShapelessRecipe.Serializer();

    @Override
    public void onInitialize() {

        // init
        BlocksInit.init();
        ItemsInit.init();

        // world gen
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("earlygame", "copper_ore_gen"), CopperOreGen.COPPER_ORE_GEN);
        
        // noBreak
        // RequiredTool.requiredToolInit();
        
        // noStoneWoodTier
        DisableWoodStoneTools.noStoneWoodTier();

        // knapEvent
        FlintKnapEvent.knapEvent();

        // crafting_shapeless
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier("earlygame", "crafting_shapeless"), SHAPELESS_RECIPE);
        
    }
    
}