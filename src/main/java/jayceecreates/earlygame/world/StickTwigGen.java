package jayceecreates.earlygame.world;

import com.mojang.serialization.Codec;
import jayceecreates.earlygame.init.BlocksInit;
import jayceecreates.earlygame.utils.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class StickTwigGen extends Feature<DefaultFeatureConfig> {

    public StickTwigGen(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();

        BlockState stateAt = world.getBlockState(pos);
        BlockState stateDown = world.getBlockState(pos.down());
        if (stateAt.isAir() && stateDown.isIn(ModBlockTags.ROCK_PLACEABLE_ON)) {
            world.setBlockState(pos, BlocksInit.STICK_TWIG_BLOCK.getDefaultState(), 3);
            return true;
        }
        return false;
    }

}