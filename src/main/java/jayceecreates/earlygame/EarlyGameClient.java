// Thanks to Bonono63 for the help!

package jayceecreates.earlygame;

import jayceecreates.earlygame.config.EarlyGameConfig;
import jayceecreates.earlygame.init.BlocksInit;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EarlyGameClient implements ClientModInitializer {

    public static EarlyGameConfig CONFIG;

    public static final String MOD_ID = "earlygame";

    @Override
    public void onInitializeClient() {
        AutoConfig.register(EarlyGameConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(EarlyGameConfig.class).getConfig();

        BlockRenderLayerMap.INSTANCE.putBlock(BlocksInit.STICK_TWIG_BLOCK, RenderLayer.getCutout());
    }
}
