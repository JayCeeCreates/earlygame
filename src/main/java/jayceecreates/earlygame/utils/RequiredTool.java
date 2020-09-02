// Thanks to BoogieMonster1O1 from the Fabric Discord!

package jayceecreates.earlygame.utils;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.text.TranslatableText;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.ActionResult;

/**
I'll get back at you guys soon(tm)

import net.minecraft.text.Text;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
*/

public class RequiredTool {

    public static void noBreak(Material material, Tag<Item> toolTag, String warningText) {

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

            // final ChopWoodHurt chopWoodHurt = new ChopWoodHurt();
            // int rand = player.getRandom().nextInt(25);

            if (world.getBlockState(pos) == null || player == null) {
                return ActionResult.PASS;
            }
            
            // if player is not in creative
            if (!player.isCreative()) {
                // if the block targeted is of a specific material
                if (world.getBlockState(pos).getMaterial().equals(material)) {
                    // if a player has a specific tool on hand, break it
                    if (player.inventory.getMainHandStack().getItem().isIn(toolTag))
                        return ActionResult.PASS;
                    // if a player has anything but a specific tool on hand, don't break it
                    else {
                        player.sendMessage(new TranslatableText(warningText), true);;
                        /**
                        System.out.println("rand1: " + rand);
                        System.out.println(player.world.isClient);
                        // it should damage the player in random chances
                        if (player.inventory.getMainHandStack().isEmpty() && rand == 1) {
                            System.out.println("Should damage");
                            player.damage(chopWoodHurt, 1.0F);
                        }
                        */
                        return ActionResult.SUCCESS;
                    }
                // if it's anything other than a specific material
                } else return ActionResult.PASS;
            // if player is creative
            } else return ActionResult.PASS;
        });
    }
    /**
    public static class ChopWoodHurt extends DamageSource {

        ChopWoodHurt() {
            super("chopWoodHurt");
        }

        @Override
        public Entity getSource() {
            return null;
        }
        
        @Override
        public Text getDeathMessage(LivingEntity entity) {
            return new TranslatableText("earlygame.splintered", entity.getDisplayName());
        }

    }
    */
}
