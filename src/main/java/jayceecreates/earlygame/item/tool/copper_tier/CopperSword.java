package jayceecreates.earlygame.item.tool.copper_tier;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class CopperSword extends SwordItem {

    public CopperSword(ToolMaterial material) {
        super(material, 3, -2.4F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }

}