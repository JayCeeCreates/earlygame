package jayceecreates.earlygame.item.tool;

import jayceecreates.earlygame.EarlyGame;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class FlintAxe extends AxeItem {

    public FlintAxe(ToolMaterial material) {
        super(material, 1, -2.8f, new Item.Settings().group(EarlyGame.EARLYGAME));
    }
    
}
