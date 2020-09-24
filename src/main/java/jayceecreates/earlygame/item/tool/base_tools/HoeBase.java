package jayceecreates.earlygame.item.tool.base_tools;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class HoeBase extends HoeItem {

    public HoeBase(ToolMaterial material) {
        super(material, -1, -2.0F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }
    
}
