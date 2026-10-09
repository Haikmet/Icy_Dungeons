package smb.icydungeon.item.projectile;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import smb.icydungeon.entity.projectile.IcicleShardEntity;

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
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResult.CONSUME;
    }

    @Override
    public boolean releaseUsing(ItemStack itemStack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (!(entityLiving instanceof Player player)) return false;

        int charge = getUseDuration(itemStack, player) - timeLeft;
        if (charge < THROW_THRESHOLD) return false;

        if (!level.isClientSide()) {
            IcicleShardEntity shard = new IcicleShardEntity(level, player, itemStack.copyWithCount(1));
            level.addFreshEntity(shard);
        }

        itemStack.consume(1, player);
        return true;
    }


    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        IcicleShardEntity icicleShard = new IcicleShardEntity(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1));
        icicleShard.pickup = AbstractArrow.Pickup.DISALLOWED;
        return icicleShard;
    }
}
