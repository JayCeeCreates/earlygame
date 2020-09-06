package jayceecreates.earlygame.world;

import jayceecreates.earlygame.init.BlocksInit;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class CopperOreGen {

    public static ConfiguredFeature<?, ?> COPPER_ORE_GEN = Feature.ORE
        .configure(new OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            BlocksInit.COPPER_ORE.getDefaultState(),
            9))
        .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64)))
        .spreadHorizontally()
        .repeat(20);
    
}
