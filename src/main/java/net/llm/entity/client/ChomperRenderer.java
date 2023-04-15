package net.llm.entity.client;


import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.llm.LostLifeMod;
import net.llm.entity.custom.ChomperEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ChomperRenderer extends GeoEntityRenderer<ChomperEntity> {
    public ChomperRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ChomperModel());
    }

    @Override
    public Identifier getTextureLocation(ChomperEntity animatable) {
        return new Identifier(LostLifeMod.MOD_ID, "textures/entity/kelenken_entity.png");
    }

    @Override
    public void render(ChomperEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}