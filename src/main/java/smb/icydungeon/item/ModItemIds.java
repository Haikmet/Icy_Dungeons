package smb.icydungeon.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import smb.icydungeon.Icy_Dungeons;

public class ModItemIds {

    public static final ResourceKey<Item> ICICLE_SHARD = create("icicle_shard");

    public static ResourceKey<Item> create(String Name) {
        return ResourceKey.create(Registries.ITEM, Icy_Dungeons.id(Name));
    }
}
