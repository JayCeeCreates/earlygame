package jayceecreates.earlygame.utils;

import jayceecreates.earlygame.world.StickTwigGen;
import jayceecreates.earlygame.world.StoneRockGen;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public abstract class ModFeature {
   public static final Feature<DefaultFeatureConfig> ROCK_BLOCK_FEATURE = Registry.register(
      Registry.FEATURE,
      new Identifier("earlygame", "rock_block_gen"),
      new StoneRockGen(DefaultFeatureConfig.CODEC));

   public static final Feature<DefaultFeatureConfig> STICK_TWIG_FEATURE = Registry.register(
      Registry.FEATURE,
      new Identifier("earlygame", "stick_twig_gen"),
      new StickTwigGen(DefaultFeatureConfig.CODEC));
}
