package net.llm.entity.client;

import mod.azure.azurelib.model.GeoModel;
import net.llm.LostLifeMod;
import net.llm.entity.custom.ChomperEntity;
import net.minecraft.util.Identifier;

public class ChomperModel extends GeoModel<ChomperEntity> {
    @Override
    public Identifier getModelResource(ChomperEntity animatable) {
        return new Identifier(LostLifeMod.MOD_ID, "geo/kelenken.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChomperEntity animatable) {
        return new Identifier(LostLifeMod.MOD_ID, "textures/entity/kelenken_entity.png");
    }

    @Override
    public Identifier getAnimationResource(ChomperEntity animatable) {
        return new Identifier(LostLifeMod.MOD_ID, "animations/kelenken.animation.json");
    }


}