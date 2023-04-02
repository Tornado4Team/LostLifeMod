package net.llm.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.llm.LostLifeMod;
import net.llm.block.custom.AnalyserBlock;
import net.llm.block.custom.CleaningTableBlock;
import net.llm.block.custom.ExtractorBlock;
import net.llm.block.custom.SynthetiserBlock;
import net.llm.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block   CENOZOIC_FOSSIL_BLOCK = registerBlock("cenozoic_fossil_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.LOSTLIFE);

    public static final Block   CLEANING_TABLE_BLOCK = registerBlock("cleaning_table_block",
            new CleaningTableBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool()), ModItemGroup.LOSTLIFE);

    public static final Block   EXTRACTOR_BLOCK = registerBlock("extractor_block",
            new ExtractorBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.LOSTLIFE);

    public static final Block   ANALYSER_BLOCK = registerBlock("analyser_block",
            new AnalyserBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.LOSTLIFE);
    public static final Block   SYNTHETISER_BLOCK = registerBlock("synthetiser_block",
            new SynthetiserBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.LOSTLIFE);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(LostLifeMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(LostLifeMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks(){
        LostLifeMod.LOGGER.info("Registering ModBlocks for "+LostLifeMod.MOD_ID);
    }
}
