package jayceecreates.earlygame.item.tool.base_tools;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeBase extends PickaxeItem {

    public PickaxeBase(ToolMaterial material) {
        super(material, 1, -2.8F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }
    
}
