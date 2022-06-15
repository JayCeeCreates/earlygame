package jayceecreates.earlygame.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class Cobblestone extends Block {

    public Cobblestone() {
        super(FabricBlockSettings.copy(Blocks.COBBLESTONE));
    }
    
}