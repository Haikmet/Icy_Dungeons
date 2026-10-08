package smb.icydungeon.item.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import smb.icydungeon.item.ModEntities;

public class IcicleShardEntity extends AbstractArrow {

    public IcicleShardEntity(EntityType<? extends IcicleShardEntity> type, Level level) {
        super(type, level);
    }

    public IcicleShardEntity(Level level, LivingEntity owner, ItemStack stack) {
        super(ModEntities.ICICLE_SHARD, owner, level, stack, null);
        this.pickup = Pickup.DISALLOWED;
    }

    public IcicleShardEntity(Level level, double x, double y, double z, ItemStack stack) {
        super(ModEntities.ICICLE_SHARD, x, y, z, level, stack, stack);
        this.pickup = Pickup.DISALLOWED;
    }

    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.TRIDENT);
    }

}
