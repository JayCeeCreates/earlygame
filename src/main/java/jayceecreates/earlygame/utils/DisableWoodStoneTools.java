package jayceecreates.earlygame.utils;

import jayceecreates.earlygame.EarlyGameClient;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.ActionResult;

public class DisableWoodStoneTools {
    public static void noStoneWoodTier() {

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

            if (world.getBlockState(pos) == null || player == null) {
                return ActionResult.PASS;
            }
            
            ItemStack itemHeld = player.inventory.getMainHandStack();
            ActionResult a = ActionResult.PASS;
            // if player is not in creative
            if (!player.isCreative()) {
                if (itemHeld.getItem() instanceof ToolItem) {
                    ToolItem tool = (ToolItem) itemHeld.getItem();
                    if (!EarlyGameClient.CONFIG.crafting.enableWoodenTools) {
                        if (tool.getMaterial().equals(ToolMaterials.WOOD))
                        a = ActionResult.FAIL;
                    }
                    if (!EarlyGameClient.CONFIG.crafting.enableStoneTools) {
                        if (tool.getMaterial().equals(ToolMaterials.STONE))
                        a = ActionResult.FAIL;
                    }
                }
                else if (itemHeld.getItem() instanceof SwordItem) {
                    SwordItem sword = (SwordItem) itemHeld.getItem();
                    if (!EarlyGameClient.CONFIG.crafting.enableWoodenTools) {
                        if (sword.getMaterial().equals(ToolMaterials.WOOD))
                        a = ActionResult.FAIL;
                    }
                    if (!EarlyGameClient.CONFIG.crafting.enableStoneTools) {
                        if (sword.getMaterial().equals(ToolMaterials.STONE))
                        a = ActionResult.FAIL;
                    }
                }
            }
            else {
                a = ActionResult.PASS;
            }
            return a;
        });

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {

            if (player == null)
                return ActionResult.PASS;

            ItemStack itemHeld = player.inventory.getMainHandStack();
            ActionResult a = ActionResult.PASS;
            // if player is not in creative
            if (!player.isCreative()) {
                if (itemHeld.getItem() instanceof ToolItem) {
                    ToolItem tool = (ToolItem) itemHeld.getItem();
                    if (!EarlyGameClient.CONFIG.crafting.enableWoodenTools) {
                        if (tool.getMaterial().equals(ToolMaterials.WOOD))
                        a = ActionResult.FAIL;
                    }
                    if (!EarlyGameClient.CONFIG.crafting.enableStoneTools) {
                        if (tool.getMaterial().equals(ToolMaterials.STONE))
                        a = ActionResult.FAIL;
                    }
                }
                else if (itemHeld.getItem() instanceof SwordItem) {
                    SwordItem sword = (SwordItem) itemHeld.getItem();
                    if (!EarlyGameClient.CONFIG.crafting.enableWoodenTools) {
                        if (sword.getMaterial().equals(ToolMaterials.WOOD))
                        a = ActionResult.FAIL;
                    }
                    if (!EarlyGameClient.CONFIG.crafting.enableStoneTools) {
                        if (sword.getMaterial().equals(ToolMaterials.STONE))
                        a = ActionResult.FAIL;
                    }
                }
            }
            else {
                a = ActionResult.PASS;
            }
            return a;
        });
    }
}
