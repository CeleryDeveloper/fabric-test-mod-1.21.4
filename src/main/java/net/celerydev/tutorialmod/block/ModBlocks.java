package net.celerydev.tutorialmod.block;

import net.celerydev.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final RegistryKey<Block> Blood_Stone_Block_Key = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(TutorialMod.MOD_ID, "blood_stone_block")
    );
    private static final Block Blood_Stone_Block = registerBlock("blood_stone_block", Blood_Stone_Block_Key,
            new Block(AbstractBlock.Settings.create().registryKey(Blood_Stone_Block_Key).strength(4f).requiresTool().sounds(BlockSoundGroup.BONE)));


    //Helper method for registering blocks
    private static Block registerBlock(String name, RegistryKey<Block> blockKey, Block block){
        registerBlockItem(name, blockKey, block);
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    //Helper method for registering block items
    private static void registerBlockItem(String name, RegistryKey<Block> blockKey, Block block){

        //Combined code from ModItems.java and fabric docs: https://docs.fabricmc.net/develop/blocks/first-block
        //If it isn't obvious I have absolutely no idea what I am doing!
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));

        //!!!MAKE SURE YOU USE "useBlockPrefixedTranslationKey()" IT'S NOT IN THE FABRIC DOCS FOR CREATING YOUR FIRST BLOCK
        // AND WITHOUT IT YOUR BLOCK NAME WON'T WORK AND YOU WILL SPIRAL INTO INSANITY!!!
        Registry.register(Registries.ITEM, itemKey, new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey()));
    }

    //Runs on initialization
    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering 'Blocks' for" + TutorialMod.MOD_ID);

        //Adds Items to the creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            //All following items are added to the 'Building Blocks' group in the creative menu
            entries.add(Blood_Stone_Block.asItem());
        });
    }
}
