package jayceecreates.earlygame.item.tool.copper_tier;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class CopperPickaxe extends PickaxeItem {

    public CopperPickaxe(ToolMaterial material) {
        super(material, 1, -2.8F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }
    
}
