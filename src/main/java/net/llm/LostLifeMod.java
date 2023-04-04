package net.llm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.llm.block.ModBlocks;
import net.llm.block.custom.entity.ModBlockEntities;
import net.llm.block.custom.screen.ModScreenHandlers;
import net.llm.entity.ModEntityClass;
import net.llm.entity.custom.ChomperEntity;
import net.llm.item.ModItemGroup;
import net.llm.item.ModItems;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class LostLifeMod implements ModInitializer {
	public static final String MOD_ID = "lostlifemod";
	public static final Logger LOGGER = LoggerFactory.getLogger("lostlifemod");

	public static final RegistryKey<PlacedFeature> CENOZOIC_FOSSIL_BLOCK_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("lostlifemod","cenozoic_fossil_block"));
	public static final RegistryKey<PlacedFeature> PALEOZOIC_FOSSIL_BLOCK_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("lostlifemod","paleozoic_fossil_block"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();


		ModScreenHandlers.registerAllScreenHandlers();

		// Proceed with mild caution.
		GeckoLib.initialize();


		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CENOZOIC_FOSSIL_BLOCK_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PALEOZOIC_FOSSIL_BLOCK_PLACED_KEY);

		FabricDefaultAttributeRegistry.register(ModEntityClass.CHOMPER, ChomperEntity.setAttributes());

		LOGGER.info("Hello Fabric world!");
	}
}