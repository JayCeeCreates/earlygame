package jayceecreates.earlygame.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class CobbledCalciteBlock extends Block {

    public CobbledCalciteBlock() {
        super(FabricBlockSettings.copy(Blocks.CALCITE).strength(1.25F));
    }
    
}