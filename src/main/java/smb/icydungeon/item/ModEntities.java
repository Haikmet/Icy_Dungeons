package smb.icydungeon.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import smb.icydungeon.Icy_Dungeons;
import smb.icydungeon.item.projectile.IcicleShardEntity;

public class ModEntities {

    public static final EntityType<IcicleShardEntity> ICICLE_SHARD = register(
            create("icicle_shard"),
            EntityType.Builder.<IcicleShardEntity>of(IcicleShardEntity::new, MobCategory.MISC)
    );

    private static ResourceKey<EntityType<?>> create(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Icy_Dungeons.id(name));
    }

    private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void init() {}
}
