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

    //Registers items
    public static Item Blood_Stone = registerItem("blood_stone", new Item.Settings());
    public static Item Blood_Stone_Gem = registerItem("blood_stone_gem", new Item.Settings());

    public static Item Celery_Stick = registerItem("celery_stick", new Item.Settings());


    //Helper method for registering items
    private static Item registerItem(String name, Item.Settings itemSettings){

        //Copied code from u/aishiteruyovivi here: https://www.reddit.com/r/fabricmc/comments/1gdp5ad/nullpointerexception_driving_me_nuts/
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }


    //Runs on initialization
    public static void registerModItems() {
        //Prints message to log
        TutorialMod.LOGGER.info("Registering 'Items' for " + TutorialMod.MOD_ID);

        //Adds Items to the creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            //All following items are added to the 'Ingredients' group in the creative menu
            entries.add(Blood_Stone);
            entries.add(Blood_Stone_Gem);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            //All following items are added to the 'Food and Drink' group in the creative menu
            entries.add(Celery_Stick);
        });
    }
}
