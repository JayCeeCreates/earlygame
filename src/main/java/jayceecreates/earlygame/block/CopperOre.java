package jayceecreates.earlygame.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class CopperOre extends Block {

    public CopperOre() {
        super(FabricBlockSettings.copy(Blocks.COAL_ORE));
    }
    
}