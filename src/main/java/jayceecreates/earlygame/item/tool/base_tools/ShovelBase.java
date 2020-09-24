package jayceecreates.earlygame.item.tool.base_tools;

import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ShovelBase extends ShovelItem {

    public ShovelBase(ToolMaterial material) {
        super(material, 1.5F, -3.0F, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }

}