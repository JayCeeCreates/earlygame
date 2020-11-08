package jayceecreates.earlygame;

import jayceecreates.earlygame.init.BlocksInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EarlyGameClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksInit.STICK_TWIG_BLOCK, RenderLayer.getCutout());
    }
}
