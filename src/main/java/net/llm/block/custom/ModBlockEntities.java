package net.llm.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.llm.LostLifeMod;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.llm.block.ModBlocks.CLEANING_TABLE_BLOCK;

public class ModBlockEntities {

    public static final BlockEntityType<CleaningTableBlockEntity> CLEANING_TABLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier("lostlifemod", "cleaning_table_block_entity"),
            FabricBlockEntityTypeBuilder.create(CleaningTableBlockEntity::new, CLEANING_TABLE_BLOCK).build()
    );

    public static void registerModBlockEntities(){
        LostLifeMod.LOGGER.info("Registering ModBlocksEntities for "+LostLifeMod.MOD_ID);
    }
}
