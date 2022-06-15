package jayceecreates.earlygame;

import jayceecreates.earlygame.config.EarlyGameConfig;
import jayceecreates.earlygame.init.*;
import jayceecreates.earlygame.utils.ModPlacedFeatures;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EarlyGame implements ModInitializer {
    
    public static EarlyGameConfig CONFIG;

    public static final Logger LOGGER = LogManager.getLogger("EarlyGame");

    @Override
    public void onInitialize() {
        
        // config
        AutoConfig.register(EarlyGameConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(EarlyGameConfig.class).getConfig();

        // init
        BlocksInit.init();
        ItemsInit.init();
        EventsInit.init();

        // world gen
        
        if (CONFIG.generateStones) {
            BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.ROCK_BLOCK.getKey().get());
        }
        if (CONFIG.generateSticks) {
            BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.STICK_TWIG.getKey().get());
        }
        
    }
    
}