package jayceecreates.earlygame.item.tool;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class FlintPickaxe extends PickaxeItem {

    public FlintPickaxe(ToolMaterial material) {
        super(material, -1, -2f, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }

    
    
}
