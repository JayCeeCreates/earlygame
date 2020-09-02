package jayceecreates.earlygame.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class CopperBlock extends Block {

    public CopperBlock() {
        super(FabricBlockSettings.of(Material.METAL).requiresTool().strength(3.0F, 6.0F));
    }
    
}
