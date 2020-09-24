package jayceecreates.earlygame.item.tool.base_tools;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem {

    public AxeBase(ToolMaterial material) {
        super(material, 7.0F, -3.2F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }

}
