package net.llm;

import net.fabricmc.api.ModInitializer;

import net.llm.item.ModItemGroup;
import net.llm.item.ModItems;
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
		// Proceed with mild caution.
		GeckoLib.initialize();
		LOGGER.info("Hello Fabric world!");
	}
}