package jayceecreates.earlygame.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class RockBlock extends Block {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(6D, 0D, 6D, 10D, 1D, 10D);

    public RockBlock() {
        super(FabricBlockSettings.of(Material.STONE).breakByHand(true).sounds(BlockSoundGroup.STONE).strength(0.15F, 0.15F).noCollision().collidable(false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        world.breakBlock(pos, (player.isCreative() ? false : true));
        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
       Vec3d vec3d = state.getModelOffset(world, pos);
       return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }
    
    @Override
    public AbstractBlock.OffsetType getOffsetType() {
       return AbstractBlock.OffsetType.XZ;
    }
    
}