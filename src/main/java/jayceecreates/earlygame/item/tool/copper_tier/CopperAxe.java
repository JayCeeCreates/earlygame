package jayceecreates.earlygame.item.tool.copper_tier;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class CopperAxe extends AxeItem {

    public CopperAxe(ToolMaterial material) {
        super(material, 7.0F, -3.2F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }
    
}
