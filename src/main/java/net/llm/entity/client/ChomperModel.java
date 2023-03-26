package net.llm.entity.client;

import net.llm.LostLifeMod;
import net.llm.entity.custom.ChomperEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ChomperModel extends GeoModel<ChomperEntity> {
    @Override
    public Identifier getModelResource(ChomperEntity object) {
        return new Identifier(LostLifeMod.MOD_ID, "geo/kelenken.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChomperEntity object) {
        return new Identifier(LostLifeMod.MOD_ID, "textures/entity/kelenken_entity.png");
    }

    @Override
    public Identifier getAnimationResource(ChomperEntity animatable) {
        return new Identifier(LostLifeMod.MOD_ID, "animations/kelenken.animation.json");
    }
}