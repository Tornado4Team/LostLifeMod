package net.llm.mixin;

import net.llm.interfaces.InjectableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnimalEntity.class)
public abstract class AnimalEntityMixin extends Entity implements InjectableEntity {
    private String injectedMob;
    private int birthTimer;
    private static final int BIRTH_TIME_IN_TICKS = 60; // this is way too short just to see if it works, you'll need to increase it to a reasonable value

    public AnimalEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    public void setInjectedMob(String injectedMob) {
        this.injectedMob = injectedMob;
    }

    @Override
    public String getInjectedMob() {
        return this.injectedMob;
    }

    @Inject(at = @At("HEAD"), method = "mobTick")
    private void mobTickMixin(CallbackInfo ci){
        if (!this.world.isClient() && this.injectedMob != null){
            this.birthTimer++;
            if (this.birthTimer > BIRTH_TIME_IN_TICKS){
                this.birth();
                this.birthTimer = 0;
                this.injectedMob = null;
            }
        }
    }

    private void birth(){
        switch (this.injectedMob){
            case "Dodo" -> this.spawnChild(EntityType.COW);
            case "Smilodon" -> this.spawnChild(EntityType.PIG);
            default -> this.spawnChild(EntityType.CHICKEN);
        }
    }

    private void spawnChild(EntityType<? extends LivingEntity> childType){
        LivingEntity child = childType.create(this.world);
        if (child != null){
            child.setPosition(this.getPos());
            this.world.spawnEntity(child);
        }
    }

    @Inject(at = @At("HEAD"), method = "writeCustomDataToNbt")
    private void writeCustomDataToNbtMixin(NbtCompound nbt, CallbackInfo ci){
        nbt.putString("InjectedMob", this.injectedMob);
        nbt.putInt("BirthInjectedMobTimer", this.birthTimer);
    }

    @Inject(at = @At("HEAD"), method = "readCustomDataFromNbt")
    private void readCustomDataFromNbtMixin(NbtCompound nbt, CallbackInfo ci){
        if (nbt.contains("InjectedMob")){
            this.injectedMob = nbt.getString("InjectedMob");
        }
        if (nbt.contains("BirthInjectedMobTimer")){
            this.birthTimer = nbt.getInt("BirthInjectedMobTimer");
        }
    }
}