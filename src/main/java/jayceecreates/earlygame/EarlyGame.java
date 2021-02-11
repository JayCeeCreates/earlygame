package jayceecreates.earlygame;

import jayceecreates.earlygame.init.*;
import jayceecreates.earlygame.utils.WoodCuttingEvent;
import jayceecreates.earlygame.utils.DisableWoodStoneTools;
import jayceecreates.earlygame.utils.FlintKnapEvent;
import jayceecreates.earlygame.utils.RecipeRemover;
import jayceecreates.earlygame.world.CopperOreGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EarlyGame implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("EarlyGame");

    @Override
    public void onInitialize() {

        // init
        BlocksInit.init();
        ItemsInit.init();

        // world gen
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("earlygame", "copper_ore_gen"), CopperOreGen.COPPER_ORE_GEN);
        
        // noStoneWoodTier
        DisableWoodStoneTools.noStoneWoodTier();

        // events
        FlintKnapEvent.knapEvent();
        WoodCuttingEvent.chopEvent();
        RecipeRemover.removeRecipe();
        
    }
    
}