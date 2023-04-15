package net.llm;

import net.fabricmc.api.ClientModInitializer;
import net.llm.entity.ModEntities;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.llm.entity.client.ChomperRenderer;

public class LostLifeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

/*
        HandledScreens.register(ModScreenHandlers.CLEANING_TABLE_SCREEN_HANDLER, CleaningTableScreen::new);
        HandledScreens.register(ModScreenHandlers.EXTRACTOR_SCREEN_HANDLER, ExtractorScreen::new);
        HandledScreens.register(ModScreenHandlers.ANALYSER_SCREEN_HANDLER, AnalyserScreen::new);
        HandledScreens.register(ModScreenHandlers.SYNTHETISER_SCREEN_HANDLER, SynthetiserScreen::new);
*/
        EntityRendererRegistry.register(ModEntities.CHOMPER, ChomperRenderer::new);
    }
}
