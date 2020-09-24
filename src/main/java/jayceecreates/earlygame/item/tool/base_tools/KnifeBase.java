package jayceecreates.earlygame.item.tool.base_tools;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KnifeBase extends SwordItem {
    
    public KnifeBase(ToolMaterial material) {
        super(material, 1, 0f, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }
    
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

}