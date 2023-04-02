package net.llm.block.custom.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.llm.LostLifeMod;
import net.llm.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockEntities {
    public static BlockEntityType<CleaningTableBlockEntity> CLEANING_TABLE;
    public static BlockEntityType<AnalyserBlockEntity> ANALYSER;


    public static void registerAllBlockEntities() {
        CLEANING_TABLE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(LostLifeMod.MOD_ID, "cleaning_table"),
                FabricBlockEntityTypeBuilder.create(CleaningTableBlockEntity::new,
                        ModBlocks.CLEANING_TABLE_BLOCK).build(null));

        ANALYSER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(LostLifeMod.MOD_ID, "analyser"),
                FabricBlockEntityTypeBuilder.create(AnalyserBlockEntity::new,
                        ModBlocks.ANALYSER_BLOCK).build(null));


    }
}
