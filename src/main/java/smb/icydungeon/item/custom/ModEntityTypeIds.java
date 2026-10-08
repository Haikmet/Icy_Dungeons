package smb.icydungeon.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import smb.icydungeon.Icy_Dungeons;

public class ModEntityTypeIds {

    public static ResourceKey<EntityType<?>> ICICLE_SHARD = create("icicle_shard");

    private static ResourceKey<EntityType<?>> create(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Icy_Dungeons.id(name));
    }
}
