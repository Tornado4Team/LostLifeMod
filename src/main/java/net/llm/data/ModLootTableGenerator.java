package net.llm.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.llm.block.ModBlocks;
import net.llm.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CENOZOIC_FOSSIL_BLOCK);
        addDrop(ModBlocks.PALEOZOIC_FOSSIL_BLOCK);

        addDrop(ModBlocks.CENOZOIC_FOSSIL_BLOCK, oreDrops(ModBlocks.CENOZOIC_FOSSIL_BLOCK, ModItems.FOSSIL_DIRTY));
        addDrop(ModBlocks.PALEOZOIC_FOSSIL_BLOCK, oreDrops(ModBlocks.PALEOZOIC_FOSSIL_BLOCK, ModItems.FOSSIL_DIRTY));
    }
}