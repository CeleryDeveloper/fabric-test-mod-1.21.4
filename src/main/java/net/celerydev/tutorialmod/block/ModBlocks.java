package net.celerydev.tutorialmod.block;

import net.celerydev.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //Helper method for registering blocks
//    private static Block registerBlock(String name, Block block, Item.Settings itemSettings){
//        registerBlockItem(name, block, itemSettings);
//    }

    //Helper method for registering block items
    private static void registerBlockItem(String name, Block block, BlockItem.Settings itemSettings){

        //Combined code from ModItems.java and fabric docs: https://docs.fabricmc.net/develop/blocks/first-block
        //If it isn't obvious I have absolutely no idea what I am doing!
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        Registry.register(Registries.ITEM, key, new BlockItem(block, new Item.Settings().registryKey(key)));
    }

    //Runs on initialization
    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering 'Blocks' for" + TutorialMod.MOD_ID);
    }
}
