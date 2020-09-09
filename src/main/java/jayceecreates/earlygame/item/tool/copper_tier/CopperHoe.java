package jayceecreates.earlygame.item.tool.copper_tier;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class CopperHoe extends HoeItem {

    public CopperHoe(ToolMaterial material) {
        super(material, -1, -2.0F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }
    
}
