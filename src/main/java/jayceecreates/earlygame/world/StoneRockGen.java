package jayceecreates.earlygame.world;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;

import jayceecreates.earlygame.init.BlocksInit;
import jayceecreates.earlygame.utils.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Lazy;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class StoneRockGen extends Feature<DefaultFeatureConfig> {

    private static final Lazy<Map<Block, Block>> A = new Lazy<>(() -> new ImmutableMap.Builder<Block, Block>()
        .put(Blocks.STONE, BlocksInit.STONE_ROCK_BLOCK)
        .put(Blocks.ANDESITE, BlocksInit.ANDESITE_ROCK_BLOCK)
        .put(Blocks.DIORITE, BlocksInit.DIORITE_ROCK_BLOCK)
        .put(Blocks.GRANITE, BlocksInit.GRANITE_ROCK_BLOCK)
        .put(Blocks.SAND, BlocksInit.SANDSTONE_ROCK_BLOCK)
        .put(Blocks.SANDSTONE, BlocksInit.SANDSTONE_ROCK_BLOCK)
        .put(Blocks.RED_SAND, BlocksInit.RED_SANDSTONE_ROCK_BLOCK)
        .put(Blocks.RED_SANDSTONE, BlocksInit.RED_SANDSTONE_ROCK_BLOCK)
        .put(Blocks.TERRACOTTA, BlocksInit.RED_SANDSTONE_ROCK_BLOCK)
        .build()
    );

    public StoneRockGen(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        
        BlockState stateAt = world.getBlockState(pos);
        BlockState stateDown = world.getBlockState(pos.down());
        if (stateAt.isAir() && ModBlockTags.ROCK_PLACEABLE_ON.contains(stateDown.getBlock())) {
            for (int y = 1; y <= 8; y++) {
                BlockPos stonePos = pos.down(y);
                BlockState stoneState = world.getBlockState(stonePos);
                if (A.get().containsKey(stoneState.getBlock())) {
                    Block looseRockBlock = A.get().get(stoneState.getBlock());
                    world.setBlockState(pos, looseRockBlock.getDefaultState(), 3);
                    return true;
                }
            }
        }
        return true;
    }

}