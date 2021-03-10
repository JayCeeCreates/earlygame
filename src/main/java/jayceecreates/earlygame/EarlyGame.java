package jayceecreates.earlygame;

import jayceecreates.earlygame.config.EarlyGameConfig;
import jayceecreates.earlygame.init.*;
import jayceecreates.earlygame.world.CopperOreGen;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.GenerationStep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EarlyGame implements ModInitializer {
    
    public static EarlyGameConfig CONFIG;

    public static final Logger LOGGER = LogManager.getLogger("EarlyGame");

    @Override
    @SuppressWarnings("deprecation")
    public void onInitialize() {
        
        // config
        AutoConfig.register(EarlyGameConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(EarlyGameConfig.class).getConfig();

        // init
        BlocksInit.init();
        ItemsInit.init();
        EventsInit.init();

        // world gen
        RegistryKey<ConfiguredFeature<?, ?>> copperOreGen = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
            new Identifier("earlygame", "copper_ore_gen"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, copperOreGen.getValue(), CopperOreGen.COPPER_ORE_GEN);
        if (CONFIG.generateCopper) BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, copperOreGen);
        
    }
    
}