package net.llm.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.llm.LostLifeMod;
import net.llm.entity.ModEntityClass;
import net.llm.item.custom.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item FOSSIL = registerItem("fossil", new FossilItem(new FabricItemSettings()));
    public static final Item FOSSIL_DIRTY = registerItem("fossil_dirty", new Item(new FabricItemSettings()));
    public static final Item DATA_DRIVE = registerItem("data_drive", new DataDriveItem(new FabricItemSettings().maxCount(1)));
    public static final Item VIAL = registerItem("vial", new VialItem(new FabricItemSettings().maxCount(16)));
    public static final Item SYRINGE = registerItem("syringe", new SyringeItem(new FabricItemSettings().maxCount(1)));

    public static final Item CHOMPER_EGG = registerItem("chomper_egg",
            new SpawnEggItem(ModEntityClass.CHOMPER,0x22b341, 0x19732e,
                    new FabricItemSettings().maxCount(16)));

    public static final Item CHOMPER_SPAWN_EGG = registerItem("chomper_spawn_egg",
            new SpawnEggItem(ModEntityClass.CHOMPER,0x918067, 0x124ba6,
                    new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(LostLifeMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        addToItemGroup(ModItemGroup.LOSTLIFE, FOSSIL);
        addToItemGroup(ModItemGroup.LOSTLIFE, FOSSIL_DIRTY);
        addToItemGroup(ModItemGroup.LOSTLIFE, VIAL);
        addToItemGroup(ModItemGroup.LOSTLIFE, DATA_DRIVE);
        addToItemGroup(ModItemGroup.LOSTLIFE, SYRINGE);


        addToItemGroup(ModItemGroup.LOSTLIFE, CHOMPER_SPAWN_EGG);
        addToItemGroup(ModItemGroup.LOSTLIFE, CHOMPER_EGG);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    public static void registerModItems(){

        LostLifeMod.LOGGER.info("Registering Mod Items for "+LostLifeMod.MOD_ID);
        addItemsToItemGroup();
    }
}
