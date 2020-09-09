package jayceecreates.earlygame.utils;

import java.util.Random;

import jayceecreates.earlygame.init.ItemsInit;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class FlintKnapEvent {

    private static final Random RANDOM = new Random();

    public static void knapEvent() {
        
        UseBlockCallback.EVENT.register((player, world, hand, block) -> {
            ItemStack stack = player.getStackInHand(hand);
            BlockPos pos = block.getBlockPos();
            BlockState state = world.getBlockState(pos);

            if (state == null || player == null)
                return ActionResult.PASS;

            if (player.inventory.getMainHandStack().getItem().equals(Items.FLINT) &&
                    state.getMaterial() == Material.STONE &&
                    block.getSide() == Direction.UP) {
                if (RANDOM.nextFloat() < 0.4f) {
                    if (RANDOM.nextFloat() < 0.7f) {
                        // known bug: event would often delay, would fix soon
                        ItemEntity itemEntity = new ItemEntity(
                            player.world,
                            block.getPos().x,
                            block.getPos().y,
                            block.getPos().z,
                            new ItemStack(
                                ItemsInit.FLINT_SHARD,
                                (player.getRandom().nextInt(2) + 1)));
                        player.world.spawnEntity(itemEntity);
                        player.swingHand(hand);
                    }
                    stack.decrement(1);
                    player.setStackInHand(hand, stack);
                    player.swingHand(hand);
                }
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        });
    }
}
