package jayceecreates.earlygame.item;

import java.util.function.Predicate;

import jayceecreates.earlygame.EarlyGame;
import jayceecreates.earlygame.entity.RockEntity;
import jayceecreates.earlygame.init.ItemsInit;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SlingshotItem extends ModRangedWeaponItem implements Vanishable {

    public SlingshotItem(Item.Settings settings) {
        super(settings);
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) user;
            boolean bl = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemStack = getRockType(playerEntity, stack);
            if (!itemStack.isEmpty() || bl) {
                if (itemStack.isEmpty()) {
                    itemStack = new ItemStack(ItemsInit.STONE_ROCK);
                }

                int i = this.getMaxUseTime(stack) - remainingUseTicks;
                float f = getPullProgress(i);
                if ((double) f >= 0.1D) {
                    boolean bl2 = bl && itemStack.getItem() == ItemsInit.STONE_ROCK;
                    if (!world.isClient) {
                        EarlyGame.LOGGER.info("Use Tick: " + f);
                        RockEntity rockEn = new RockEntity(world, user);
                        rockEn.setItem(itemStack);
                        rockEn.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, f * 1.5F, 1.0F);

                        int j = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
                        if (j > 0) {
                            rockEn.setDamage(rockEn.getDamage() + (double)j * 0.5D + 0.5D);
                        }

                        int k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack);
                        if (k > 0) {
                            rockEn.setPunch(k);
                        }

                        if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                            rockEn.setOnFireFor(100);
                        }

                        stack.damage(1, (LivingEntity) playerEntity, ((p) -> {
                            p.sendToolBreakStatus(playerEntity.getActiveHand());
                        }));
                        
                        world.spawnEntity(rockEn);
                    }

                    world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!bl2 && !playerEntity.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                        if (itemStack.isEmpty()) {
                            playerEntity.getInventory().removeOne(itemStack);
                        }
                    }

                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }
    }

    public static float getPullProgress(int useTicks) {
       float f = (float)useTicks / 20.0F;
       f = (f * f + f * 2.0F) / 3.0F;
       if (f > 1.0F) {
          f = 1.0F;
       }
 
       return f;
    }

    public int getMaxUseTime(ItemStack stack) {
       return 72000;
    }
 
    public UseAction getUseAction(ItemStack stack) {
       return UseAction.BOW;
    }

    public TypedActionResult <ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        boolean bl = !getRockType(user, itemStack).isEmpty();
        if (!user.getAbilities().creativeMode && !bl) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    public ItemStack getRockType(PlayerEntity player, ItemStack stack) {
        if (!(stack.getItem() instanceof ModRangedWeaponItem)) {
            return ItemStack.EMPTY;
        } else {
            Predicate<ItemStack> predicate = ((ModRangedWeaponItem)stack.getItem()).getHeldProjectiles();
            ItemStack itemStack = ModRangedWeaponItem.getHeldProjectile(player, predicate);
            if (!itemStack.isEmpty()) {
                return itemStack;
            } else {
                predicate = ((ModRangedWeaponItem)stack.getItem()).getProjectiles();
  
                for(int i = 0; i < player.getInventory().size(); ++i) {
                    ItemStack itemStack2 = player.getInventory().getStack(i);
                    if (predicate.test(itemStack2)) {
                        return itemStack2;
                    }
                }
  
                return player.getAbilities().creativeMode ? new ItemStack(ItemsInit.STONE_ROCK) : ItemStack.EMPTY;
            }
        }
    }

    @Override
    public Predicate <ItemStack> getProjectiles() {
        return SLINGSHOT_PROJECTILES;
    }

    @Override
    public int getRange() {
        return 15;
    }
}
