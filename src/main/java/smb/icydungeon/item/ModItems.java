package smb.icydungeon.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import smb.icydungeon.Icy_Dungeons;
import smb.icydungeon.item.projectile.IcicleShardItem;

import java.util.function.Function;

public class ModItems {

    public static final Item ICICLE_SHARD = registerItem(
            ModItemIds.ICICLE_SHARD,
            IcicleShardItem::new,
            new Item.Properties().stacksTo(16)
    );


    public static Item registerItem(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        Icy_Dungeons.LOGGER.info("Registering mod items for" + Icy_Dungeons.MOD_ID);
    }
}