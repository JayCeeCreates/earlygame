// Thanks to ! !#6008 from the Fabric Discord for the help!

package jayceecreates.earlygame.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import jayceecreates.earlygame.utils.ModBlockTags;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class SlowDigSpeedMixin extends LivingEntity {
    
    protected SlowDigSpeedMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
        method = "getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F",
        at = @At("RETURN"),
        cancellable = true
    )
    private void blockBreak(BlockState state, CallbackInfoReturnable<Float> cir) {
        if (!this.getMainHandStack().getItem().isIn(FabricToolTags.SHOVELS) &&
            ModBlockTags.SLOW_DIGGING.contains(state.getBlock()))
            cir.setReturnValue(cir.getReturnValue() / 5.0F);
    }
    
}