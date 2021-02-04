package jayceecreates.earlygame.world;

import java.util.Random;

import com.mojang.serialization.Codec;

import jayceecreates.earlygame.EarlyGameClient;
import jayceecreates.earlygame.init.BlocksInit;
import jayceecreates.earlygame.utils.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class StickTwigGen extends Feature<DefaultFeatureConfig> {

    public StickTwigGen(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos,
            DefaultFeatureConfig featureConfig) {
        if (EarlyGameClient.CONFIG.generateSticks) {
            BlockState stateAt = world.getBlockState(pos);
            BlockState stateDown = world.getBlockState(pos.down());
            if (stateAt.isAir() && ModBlockTags.ROCK_PLACEABLE_ON.contains(stateDown.getBlock())) {
                world.setBlockState(pos, BlocksInit.STICK_TWIG_BLOCK.getDefaultState(), 3);
                return true;
            }
            return true;
        }
        else return false;
    }

}