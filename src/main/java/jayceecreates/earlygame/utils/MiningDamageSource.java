package jayceecreates.earlygame.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class MiningDamageSource {

    public static class SplinterDamage extends DamageSource {

        public SplinterDamage() {
            super("splinter_damage");
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

    public static class BrokenHandDamage extends DamageSource {

        public BrokenHandDamage() {
            super("broken_hand_damage");
        }
    
        @Override
        public Entity getSource() {
            return null;
        }
        
        @Override
        public Text getDeathMessage(LivingEntity entity) {
            return new TranslatableText("earlygame.broken_bones", entity.getDisplayName());
        }

    }

}