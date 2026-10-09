package smb.icydungeon.item.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smb.icydungeon.item.ModEntities;
import smb.icydungeon.item.ModItems;

public class IcicleShardEntity extends AbstractArrow {

    private static final Logger log = LoggerFactory.getLogger(IcicleShardEntity.class);

    public IcicleShardEntity(EntityType<? extends IcicleShardEntity> type, Level level) {
        super(type, level);
    }

    public IcicleShardEntity(Level level, LivingEntity owner, ItemStack stack) {
        super(ModEntities.ICICLE_SHARD, owner, level, stack, null);
        this.pickup = Pickup.DISALLOWED;
        this.setBaseDamage(IcicleShardItem.BASE_DAMAGE);
    }

    public IcicleShardEntity(Level level, double x, double y, double z, ItemStack stack) {
        super(ModEntities.ICICLE_SHARD, x, y, z, level, stack, stack);
        this.pickup = Pickup.DISALLOWED;
    }

    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.ICICLE_SHARD);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        shatter();
    }

    @Override
    protected  void onHitBlock(BlockHitResult result) {
        shatter();
    }

    private void shatter() {
        if (!level().isClientSide()) {
            level().broadcastEntityEvent(this, (byte) 3);
            discard();
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; i++) {
                level().addParticle(ParticleTypes.SNOWFLAKE, getX(), getY(), getZ(),
                        (random.nextDouble() - 0.5) * 0.2,
                        random.nextDouble() * 0.2,
                        (random.nextDouble() - 0.5) * 0.2);
            }
        } else {
            super.handleEntityEvent(id);
        }
    }

}
