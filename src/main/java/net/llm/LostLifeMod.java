package net.llm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.llm.block.ModBlocks;
import net.llm.entity.ModEntityClass;
import net.llm.entity.custom.ChomperEntity;
import net.llm.item.ModItemGroup;
import net.llm.item.ModItems;
import net.llm.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class LostLifeMod implements ModInitializer {
	public static final String MOD_ID = "lostlifemod";
	public static final Logger LOGGER = LoggerFactory.getLogger("lostlifemod");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBLocks();
		ModWorldGeneration.generateModWorldGen();
		// Proceed with mild caution.
		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(ModEntityClass.CHOMPER, ChomperEntity.setAttributes());

		LOGGER.info("Hello Fabric world!");
	}
}