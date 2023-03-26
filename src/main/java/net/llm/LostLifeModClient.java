package net.llm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.llm.entity.ModEntityClass;
import net.llm.entity.client.ChomperRenderer;

public class LostLifeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntityClass.CHOMPER, ChomperRenderer::new);
    }
}
