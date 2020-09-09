package jayceecreates.earlygame.item.tool.flint_tier;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class FlintAxe extends AxeItem {

    public FlintAxe(ToolMaterial material) {
        super(material, 1, -2.5f, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }
    
}
