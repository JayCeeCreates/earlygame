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

public class RockBlock extends Block {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(6D, 0D, 6D, 10D, 1D, 10D);

    public RockBlock() {
        super(FabricBlockSettings.of(Material.STONE).breakByHand(true).sounds(BlockSoundGroup.STONE).strength(0.15F, 0.15F).noCollision().collidable(false));
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
        if (!player.isSneaking()) {
            world.breakBlock(pos, (player.isCreative() ? false : true));
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
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