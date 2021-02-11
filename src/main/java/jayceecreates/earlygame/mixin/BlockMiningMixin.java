// Thanks to ! !#6008 from the Fabric Discord for the help!

package jayceecreates.earlygame.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import jayceecreates.earlygame.EarlyGameClient;
import jayceecreates.earlygame.init.BlocksInit;
import jayceecreates.earlygame.utils.MiningDamageSource;
import jayceecreates.earlygame.utils.ModBlockTags;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class BlockMiningMixin extends LivingEntity {
    
    protected BlockMiningMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
        method = "getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F",
        at = @At("RETURN"),
        cancellable = true
    )
    private void blockBreak(BlockState state, CallbackInfoReturnable<Float> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;
        double rand = Math.random();

        if (EarlyGameClient.CONFIG.harderGroundBlocks) {
            if (!player.inventory.getMainHandStack().getItem().isIn(FabricToolTags.SHOVELS)
                    && ModBlockTags.SLOW_DIGGING.contains(state.getBlock()))
                cir.setReturnValue(cir.getReturnValue() / 3.8F);
        }
    
        if (!player.isCreative()) {
            boolean isStone = (state.getMaterial().equals(Material.STONE) ||
                state.getMaterial().equals(Material.REPAIR_STATION) ||
                state.getMaterial().equals(Material.METAL))
                && !state.isIn(ModBlockTags.ROCKS);
            boolean isWood = (state.getMaterial().equals(Material.WOOD) ||
                state.getMaterial().equals(Material.NETHER_WOOD) ||
                state.getMaterial().equals(Material.BAMBOO))
                && !state.equals(BlocksInit.STICK_TWIG_BLOCK.getDefaultState());
            boolean isBlacklisted = state.isIn(ModBlockTags.BLACKLISTED_BLOCKS);
            if (isStone)
                if (!isBlacklisted ?
                        !player.inventory.getMainHandStack().getItem().isIn(FabricToolTags.PICKAXES) :
                        !player.inventory.getMainHandStack().getItem().isIn(FabricToolTags.AXES))
                {
                    if (EarlyGameClient.CONFIG.warningMessage)
                        player.sendMessage(new TranslatableText(!isBlacklisted ? "earlygame.pick_required" : "earlygame.axe_required"), true);
                    cir.setReturnValue(0.0F);
                    if (player.inventory.getMainHandStack().isEmpty() && rand <= EarlyGameClient.CONFIG.damageProbability * .01)
                        if (!isBlacklisted)
                            player.damage(new MiningDamageSource.BrokenHandDamage(), 2.0F);
                        else
                            player.damage(new MiningDamageSource.SplinterDamage(), 1.0F);
                }

            if (isWood)
                if (!isBlacklisted ?
                        !player.inventory.getMainHandStack().getItem().isIn(FabricToolTags.AXES) :
                        !player.inventory.getMainHandStack().getItem().isIn(FabricToolTags.PICKAXES))
                {
                    if (EarlyGameClient.CONFIG.warningMessage)
                        player.sendMessage(new TranslatableText(!isBlacklisted ? "earlygame.axe_required" : "earlygame.pick_required"), true);
                    cir.setReturnValue(0.0F);
                    if (player.inventory.getMainHandStack().isEmpty() && rand <= EarlyGameClient.CONFIG.damageProbability * .01)
                    if (!isBlacklisted)
                        player.damage(new MiningDamageSource.SplinterDamage(), 1.0F);
                    else
                        player.damage(new MiningDamageSource.BrokenHandDamage(), 2.0F);
                }

        }
    }
    
}