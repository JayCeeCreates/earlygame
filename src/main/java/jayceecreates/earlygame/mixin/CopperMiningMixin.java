package jayceecreates.earlygame.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.*;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

// Thanks to Snowdaw#3874 from the Fabric Discord server for the help!

@Mixin(PlayerEntity.class)
public abstract class CopperMiningMixin extends LivingEntity {

    @Shadow @Final
    private PlayerInventory inventory;

    @Inject(
        method = "canHarvest(Lnet/minecraft/block/BlockState;)Z",
        at = @At("HEAD"),
        cancellable = true
    )
    private void canHarvest(BlockState state, CallbackInfoReturnable < Boolean > cir) {
        Item heldItem = this.inventory.getMainHandStack().getItem();

        if (heldItem instanceof ToolItem) {
            int miningLevel = ((ToolItem) heldItem).getMaterial().getMiningLevel();
            String blockName = Registry.BLOCK.getId(state.getBlock()).toString();

            if (heldItem instanceof PickaxeItem)
                if (miningLevel == 0 && blockName.equals("minecraft:copper_ore"))
                    cir.setReturnValue(true);
        }
    }

    protected CopperMiningMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

}