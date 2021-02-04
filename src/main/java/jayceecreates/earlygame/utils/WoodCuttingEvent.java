package jayceecreates.earlygame.utils;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

import jayceecreates.earlygame.EarlyGameClient;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;

public class WoodCuttingEvent {

    private static final Random RANDOM = new Random();

    public static void chopEvent() {
        
        UseBlockCallback.EVENT.register((player, world, hand, block) -> {
            ItemStack stack = player.getStackInHand(hand);
            BlockPos pos = block.getBlockPos();
            BlockState state = world.getBlockState(pos);

            double r1 = RANDOM.nextDouble();
            int r2 = 0;

            boolean
                isGeneralAxe = player.inventory.getMainHandStack().getItem().isIn(FabricToolTags.AXES),
                isAxe = player.inventory.getMainHandStack().getItem().isIn(ModItemTags.AXES),
                isSaw = player.inventory.getMainHandStack().getItem().isIn(ModItemTags.SAWS),
                isLog = state.getBlock().isIn(BlockTags.LOGS),
                isPlank = state.getBlock().isIn(BlockTags.PLANKS);

            if (state == null || player == null)
                return ActionResult.PASS;

            if (isGeneralAxe && (isLog || isPlank) && player.isSneaking()) {
                if (!world.isClient) {
                    if (r1 <= EarlyGameClient.CONFIG.woodChoppingProb) {
                        world.breakBlock(pos, false);
                        ItemEntity itemEntity = null;
                        if (isLog) {
                            if (isAxe) r2 = RANDOM.nextInt(3) + 2;
                            if (isSaw) r2 = 4;
                            itemEntity = new ItemEntity(
                                player.world,
                                block.getPos().x,
                                block.getPos().y - 0.5,
                                block.getPos().z,
                                new ItemStack(
                                    WoodType.getType(state.getBlock()).getOutputBlock(),
                                    r2));
                        }
                        if (isPlank) {
                            if (isAxe) r2 = RANDOM.nextInt(2) + 1;
                            if (isSaw) r2 = 2;
                            itemEntity = new ItemEntity(
                                player.world,
                                block.getPos().x,
                                block.getPos().y - 0.5,
                                block.getPos().z,
                                new ItemStack(
                                    Items.STICK,
                                    r2));
                        }
                        player.world.spawnEntity(itemEntity);
                    }
                    else
                        world.playSound(null, pos, SoundEvents.BLOCK_WOOD_HIT,
                            SoundCategory.PLAYERS, 1.0F, 1.0F);

                    if (stack.getItem().isDamageable()) {
                            
                        ItemStack savedStack = stack.copy();
                        boolean shouldAttemptDmg = true;
                        Random random = new Random();
                        int unbreakingLvl = EnchantmentHelper.getLevel(Enchantments.UNBREAKING, savedStack);
        
                        if (unbreakingLvl > 0) shouldAttemptDmg = (1 + random.nextInt(5)) <= unbreakingLvl;
        
                        if (savedStack.getDamage() < savedStack.getMaxDamage()) {
        
                            if (shouldAttemptDmg) savedStack.setDamage(savedStack.getDamage() + 1);
        
                            player.setStackInHand(hand, savedStack);
        
                        }
        
                        else player.setStackInHand(hand, ItemStack.EMPTY);
        
                    }
                    
                }
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        });
    }
}
