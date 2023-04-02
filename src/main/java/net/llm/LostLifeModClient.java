package net.llm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.llm.block.custom.screen.CleaningTableScreen;
import net.llm.block.custom.screen.ModScreenHandlers;
import net.llm.entity.ModEntityClass;
import net.llm.entity.client.ChomperRenderer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class LostLifeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        HandledScreens.register(ModScreenHandlers.CLEANING_TABLE_SCREEN_HANDLER, CleaningTableScreen::new);


        EntityRendererRegistry.register(ModEntityClass.CHOMPER, ChomperRenderer::new);
    }
}
