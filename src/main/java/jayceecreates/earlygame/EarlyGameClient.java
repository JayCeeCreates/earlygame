// Thanks to Bonono63 for the help!

package jayceecreates.earlygame;

import jayceecreates.earlygame.init.BlocksInit;
import jayceecreates.earlygame.init.ItemsInit;
import jayceecreates.earlygame.item.SlingshotItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class EarlyGameClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksInit.STICK_TWIG_BLOCK, RenderLayer.getCutout());
        slingshotPredicates((SlingshotItem)ItemsInit.SLINGSHOT);
    }

    public static void slingshotPredicates(SlingshotItem item) {
        FabricModelPredicateProviderRegistry.register(item, new Identifier("pull"),(itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) return 0.0F;
            else return livingEntity.getActiveItem() != itemStack ? 0.0F : (float)(itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 15.0F;
        });

        FabricModelPredicateProviderRegistry.register(item, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, seed) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F);
    }
}
