package smb.icydungeon.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.Level;
import smb.icydungeon.Icy_Dungeons;

import java.util.function.Function;

public class ModItems {


    private static Item registerItem(String name, Function<Item.Properties, Item> itemFunction) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Icy_Dungeons.MOD_ID, name),
                itemFunction.apply(new  Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Icy_Dungeons.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Icy_Dungeons.LOGGER.info("Registering mod items for" + Icy_Dungeons.MOD_ID);
    }
}
