package jayceecreates.earlygame;

import jayceecreates.earlygame.config.EarlyGameConfig;
import jayceecreates.earlygame.init.*;
import jayceecreates.earlygame.utils.ModConfiguredFeatures;
import jayceecreates.earlygame.world.StickTwigGen;
import jayceecreates.earlygame.world.StoneRockGen;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("deprecation")
public class EarlyGame implements ModInitializer {
    
    public static EarlyGameConfig CONFIG;

    public static final Logger LOGGER = LogManager.getLogger("EarlyGame");

    // Rock Feature stuff
    RegistryKey<ConfiguredFeature<?, ?>> rockBlock = RegistryKey.of(
      Registry.CONFIGURED_FEATURE_KEY,
      new Identifier("earlygame", "rock_block_gen"));
    private static final Feature<DefaultFeatureConfig> ROCK_BLOCK_FEATURE = new StoneRockGen(
      DefaultFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> ROCK_BLOCK_CONFIGURED_FEATURE = ROCK_BLOCK_FEATURE
       .configure(FeatureConfig.DEFAULT);
    public static PlacedFeature ROCK_BLOCK_PLACED_FEATURE = ROCK_BLOCK_CONFIGURED_FEATURE
      .withPlacement(
        SquarePlacementModifier.of(),
        PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
        BiomePlacementModifier.of());
    
    // Stick Feature stuff
    RegistryKey<ConfiguredFeature<?, ?>> stickTwig = RegistryKey.of(
      Registry.CONFIGURED_FEATURE_KEY,
      new Identifier("earlygame", "stick_twig_gen"));
    private static final Feature<DefaultFeatureConfig> STICK_TWIG_FEATURE = new StickTwigGen(
      DefaultFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> STICK_TWIG_CONFIGURED_FEATURE = STICK_TWIG_FEATURE
      .configure(FeatureConfig.DEFAULT);
    public static PlacedFeature STICK_TWIG_PLACED_FEATURE = STICK_TWIG_CONFIGURED_FEATURE
      .withPlacement(
        SquarePlacementModifier.of(),
        PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
        BiomePlacementModifier.of());

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
        Registry.register(Registry.FEATURE, rockBlock.getValue(), ROCK_BLOCK_FEATURE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rockBlock.getValue(), ROCK_BLOCK_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, rockBlock.getValue(), ROCK_BLOCK_PLACED_FEATURE);
        Registry.register(Registry.FEATURE, stickTwig.getValue(), STICK_TWIG_FEATURE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, stickTwig.getValue(), STICK_TWIG_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, stickTwig.getValue(), STICK_TWIG_PLACED_FEATURE);
        
        if (CONFIG.generateStones) {
          BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.VEGETAL_DECORATION,
            RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            rockBlock.getValue()));
        }
        if (CONFIG.generateSticks) {
          BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.VEGETAL_DECORATION,
            RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            stickTwig.getValue()));
        }
        
    }
    
}