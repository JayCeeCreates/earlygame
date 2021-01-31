// Thanks to BoogieMonster1O1#2458 from the Fabric Discord for the help!

package jayceecreates.earlygame.utils;

import jayceecreates.earlygame.init.BlocksInit;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.text.TranslatableText;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.ActionResult;

/*import net.minecraft.text.Text;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;*/

public class RequiredTool {

    public static void noBreak(Material material, Tag<Item> toolTag, String warningText) {
        
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            //int rand = player.getRandom().nextInt(25);

            if (world.getBlockState(pos) == null || player == null) {
                return ActionResult.PASS;
            }
            
            if (!player.isCreative()) {

                if (world.getBlockState(pos).getMaterial().equals(material) && (
                    !world.getBlockState(pos).isIn(ModBlockTags.ROCKS) &&
                    !world.getBlockState(pos).equals(BlocksInit.STICK_TWIG_BLOCK.getDefaultState())
                )) {
                    if (!player.inventory.getMainHandStack().getItem().isIn(toolTag)) {
                        player.sendMessage(new TranslatableText(warningText), true);
                        /*System.out.println("B" + player.world.isClient);
                        if (player.inventory.getMainHandStack().isEmpty() && rand == 1) {
                            if (!world.isClient()) {
                                System.out.println("C" + player.world.isClient);
                                System.out.println("Should damage");
                                player.damage(new ChopWoodHurt(), 1.0F);
                            }
                            return ActionResult.SUCCESS;
                        }*/
                        return ActionResult.SUCCESS;
                    }
                }

            }
            
            return ActionResult.PASS;
        });
    }
    
    /*public static class ChopWoodHurt extends DamageSource {

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

    }*/
    
    public static void requiredToolInit() {
        noBreak(Material.WOOD, FabricToolTags.AXES, "You need an axe to cut wood!"); // wood cutting
        noBreak(Material.NETHER_WOOD, FabricToolTags.AXES, "You need an axe to cut wood!"); // wood cutting
        noBreak(Material.BAMBOO, FabricToolTags.AXES, "You need an axe to cut wood!"); // bamboo cutting
        noBreak(Material.STONE, FabricToolTags.PICKAXES, "You need a pickaxe to mine!"); // mining
        noBreak(Material.REPAIR_STATION, FabricToolTags.PICKAXES, "You need a pickaxe to mine!"); // mining
        noBreak(Material.METAL, FabricToolTags.PICKAXES, "You need a pickaxe to mine!"); // mining
    }
}
