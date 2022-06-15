package jayceecreates.earlygame.block;

import jayceecreates.earlygame.init.BlocksInit;
import jayceecreates.earlygame.utils.ModBlockTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class StickTwigBlock extends Block {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(4D, 0.01D, 4D, 12D, 0.02D, 12D);
    
    public StickTwigBlock() {
        super(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(0.15F, 0.15F).noCollision().collidable(false));
    }

    protected boolean canPlaceOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return !(
            floor.isAir() ||
            floor.isOf(Blocks.GRASS) ||
            floor.isOf(Blocks.TALL_GRASS) ||
            floor.isIn(BlockTags.SAND) ||
            floor.isOf(Blocks.WATER) ||
            floor.isOf(Blocks.LAVA) ||
            floor.isIn(BlockTags.LEAVES) ||
            floor.isIn(BlockTags.FLOWERS) ||
            floor.isIn(BlockTags.FLOWER_POTS) ||
            floor.isIn(ModBlockTags.ROCKS) ||
            floor.isOf(BlocksInit.STICK_TWIG_BLOCK)
        );
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
       Vec3d vec3d = state.getModelOffset(world, pos);
       return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        world.breakBlock(pos, (player.isCreative() ? false : true));
        return ActionResult.SUCCESS;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return this.canPlaceOnTop(world.getBlockState(blockPos), world, blockPos);
    }
    
    @Override
    public AbstractBlock.OffsetType getOffsetType() {
       return AbstractBlock.OffsetType.XZ;
    }

    @Override
    public void neighborUpdate(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
            boolean isMoving)
    {
        super.neighborUpdate(state, worldIn, pos, blockIn, fromPos, isMoving);
        if (!this.canPlaceAt(state, worldIn, pos))
        {
            worldIn.breakBlock(pos, true);
        }
    }
}
