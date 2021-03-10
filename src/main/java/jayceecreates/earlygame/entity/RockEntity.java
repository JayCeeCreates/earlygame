package jayceecreates.earlygame.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RockEntity extends SnowballEntity {

   public RockEntity(World world, LivingEntity owner) {
      super(world, owner);
   }

   private double damage = 2.0;
   private int punch;

   @Override
   protected void onEntityHit(EntityHitResult entityHitResult) {
      super.onEntityHit(entityHitResult);
      Entity entity = entityHitResult.getEntity();
      if (entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)damage)) {
         if (entity.getType() == EntityType.ENDERMAN) return;
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (this.punch > 0) {
               Vec3d vec3d = this.getVelocity().multiply(1.0D, 0.0D, 1.0D).normalize().multiply((double)this.punch * 0.6D);
               if (vec3d.lengthSquared() > 0.0D) {
                  livingEntity.addVelocity(vec3d.x, 0.1D, vec3d.z);
               }
            }
         }
      }
   }

   public double getDamage() { return this.damage; }

   public void setDamage(double damage) { this.damage = damage; }

   public void setPunch(int punch) {
      this.punch = punch;
   }
}
