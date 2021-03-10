package jayceecreates.earlygame.item.tool.flint_tier;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class FlintSaw extends AxeItem {
    private static final Set<Material> WOODEN_MATERIAL;

    public FlintSaw(ToolMaterial material, Settings settings) {
        super(material, 1.0F, -2.5F, settings);
    }
    
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return WOODEN_MATERIAL.contains(material) ? this.miningSpeed - 2.0F : super.getMiningSpeedMultiplier(stack, state) - 2.0F;
    }

    static {
        WOODEN_MATERIAL = Sets.newHashSet(new Material[]{Material.WOOD, Material.NETHER_WOOD, Material.PLANT, Material.REPLACEABLE_PLANT, Material.BAMBOO, Material.GOURD});
    }

}
