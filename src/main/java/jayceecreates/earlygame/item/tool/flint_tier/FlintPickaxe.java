package jayceecreates.earlygame.item.tool.flint_tier;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class FlintPickaxe extends PickaxeItem {

    public FlintPickaxe(ToolMaterial material) {
        super(material, 0, -1.8f, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }

    
    
}
