package jayceecreates.earlygame.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MapColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class RockBlock extends Block implements Waterloggable {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(6D, 0D, 6D, 10D, 1D, 10D);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public RockBlock() {
        super(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_GRAY).strength(0.15F, 0.15F).sounds(BlockSoundGroup.STONE).noCollision().collidable(false).offsetType(AbstractBlock.OffsetType.XZ));
        this.setDefaultState((BlockState)this.getDefaultState().with(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        WorldAccess worldAccess = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        boolean bl = worldAccess.getBlockState(blockPos).getBlock() == Blocks.WATER;
        if (bl) return (BlockState)this.getDefaultState().with(WATERLOGGED, Boolean.TRUE);
        return (BlockState)this.getDefaultState();
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
        return ActionResult.PASS;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState stateUnder = world.getBlockState(pos.down());
        return stateUnder.isSideSolidFullSquare(world, pos.down(), Direction.UP);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public void neighborUpdate(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
            boolean isMoving) {
        super.neighborUpdate(state, worldIn, pos, blockIn, fromPos, isMoving);
        if (!this.canPlaceAt(state, worldIn, pos))
            worldIn.breakBlock(pos, true);
        else if (state.get(WATERLOGGED))
            worldIn.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
    }

    public BlockState asWaterlogged() {
        return (BlockState)this.getDefaultState().with(WATERLOGGED, Boolean.TRUE);
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
       return Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState);
    }

    @Override
    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
       return Waterloggable.super.canFillWithFluid(world, pos, state, fluid);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        switch(type) {
        case LAND:
            return false;
        case WATER:
            return world.getFluidState(pos).isIn(FluidTags.WATER);
        case AIR:
            return false;
        default:
            return false;
        }
    }

    @Override
    public boolean canMobSpawnInside() {
        return true;
    }

}