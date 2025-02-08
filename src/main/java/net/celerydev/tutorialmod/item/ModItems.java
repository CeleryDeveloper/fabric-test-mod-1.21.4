package net.celerydev.tutorialmod.item;

import net.celerydev.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item Blood_Stone = registerItem("blood_stone", new Item.Settings());
    public static Item Blood_Stone_Gem = registerItem("blood_stone_gem", new Item.Settings());

    //Helper method for registering items
    private static Item registerItem(String name, Item.Settings itemSettings){
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    //Runs on initialization
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering 'Items' for" + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(Blood_Stone);
            entries.add(Blood_Stone_Gem);
        });
    }
}
