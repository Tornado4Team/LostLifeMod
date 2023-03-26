package net.llm.entity.client;

import net.llm.LostLifeMod;
import net.llm.entity.custom.ChomperEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ChomperRenderer extends GeoEntityRenderer<ChomperEntity> {
    public ChomperRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ChomperModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureLocation(ChomperEntity instance) {
        return new Identifier(LostLifeMod.MOD_ID, "textures/entity/kelenken_entity.png");
    }


    @Override
    public RenderLayer getRenderType(ChomperEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
