package jayceecreates.earlygame.world;

import jayceecreates.earlygame.init.BlocksInit;
import net.minecraft.world.gen.decorator.CountNoiseDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class StickTwigGen {

    public static ConfiguredFeature<?, ?> STICK_TWIG_GEN = Feature.RANDOM_PATCH
        .configure((new RandomPatchFeatureConfig.Builder(
            new SimpleBlockStateProvider(
                BlocksInit.STICK_TWIG_BLOCK.getDefaultState()
            ),
            SimpleBlockPlacer.INSTANCE))
                .tries(32).build())
        .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE)
        .decorate(Decorator.COUNT_NOISE
            .configure(new CountNoiseDecoratorConfig(-5.0D, 1, 1)));

}