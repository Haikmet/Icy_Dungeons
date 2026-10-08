package smb.icydungeon.item.projectile;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;

import java.util.List;


public class IcicleShardItem extends Item implements ProjectileItem {
    public static final int THROW_THRESHOLD = 10;
    public static final float BASE_DAMAGE = 8.0F;
    public static final float PROJECTILE_SHOOT_POWER = 2.5F;

    public IcicleShardItem(final Item.Properties properties) {
        super(properties);
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(), 1.0F, 2, true);
    }

    public ItemUseAnimation getUseAnimation(final ItemStack itemStack) {
        return ItemUseAnimation.TRIDENT;
    }

    public int getUseDuration(final ItemStack itemStack, final LivingEntity user) {
        return 72000;
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        IcicleShardEntity icicleShard = new IcicleShardEntity(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1));
        icicleShard.pickup = AbstractArrow.Pickup.DISALLOWED;
        return icicleShard;
    }


}
