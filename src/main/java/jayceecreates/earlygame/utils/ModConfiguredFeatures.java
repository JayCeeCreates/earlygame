package jayceecreates.earlygame.utils;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModConfiguredFeatures {
   public static final ConfiguredFeature<?, ?> ROCK_BLOCK = 
      ModFeature.ROCK_BLOCK_FEATURE
         .configure(FeatureConfig.DEFAULT)
         .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP)
         .repeat(4);

   public static final ConfiguredFeature<?, ?> STICK_TWIG = 
      ModFeature.STICK_TWIG_FEATURE
         .configure(FeatureConfig.DEFAULT)
         .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP)
         .repeat(3);
}
