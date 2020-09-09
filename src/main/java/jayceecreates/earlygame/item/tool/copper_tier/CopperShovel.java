package jayceecreates.earlygame.item.tool.copper_tier;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class CopperShovel extends ShovelItem {

    public CopperShovel(ToolMaterial material) {
        super(material, 1.5F, -3.0F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }

}