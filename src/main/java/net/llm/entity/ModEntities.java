package net.llm.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.llm.LostLifeMod;
import net.llm.entity.custom.ChomperEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ChomperEntity> CHOMPER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(LostLifeMod.MOD_ID, "chomper"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChomperEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());
}
