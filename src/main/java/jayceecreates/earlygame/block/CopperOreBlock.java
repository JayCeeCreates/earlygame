package jayceecreates.earlygame.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class CopperOreBlock extends Block {

    public CopperOreBlock() {
        super(FabricBlockSettings.copy(Blocks.COAL_ORE));
    }
    
}