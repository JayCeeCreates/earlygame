package jayceecreates.earlygame.item.tool.base_tools;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordBase extends SwordItem {

    public SwordBase(ToolMaterial material) {
        super(material, 3, -2.4F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }

}