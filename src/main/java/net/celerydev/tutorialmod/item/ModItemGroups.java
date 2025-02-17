package net.celerydev.tutorialmod.item;

import net.celerydev.tutorialmod.TutorialMod;
import net.celerydev.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //Registers a group
    public static final ItemGroup Tutorial_Mod_Group = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "tutorial_mod_group"),
            //This sets the icon for the group
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.Celery_Stick))
                    //Use this key in the en_us.json file to give the group a name
                    .displayName(Text.translatable("itemgroup.tutorialmod.tutorial_mod_group"))
                    .entries((displayContext, entries) -> {
                        //All following will be added to the group
                        entries.add(ModItems.Celery_Stick);
                        entries.add(ModItems.Blood_Stone);
                        entries.add(ModItems.Blood_Stone_Gem);
                        entries.add(ModBlocks.Blood_Stone_Block);
                    }).build());

    //Runs on initialization
    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering 'item groups' for " + TutorialMod.MOD_ID);
    }
}
