package net.llm.item.custom;

import net.llm.interfaces.InjectableEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SyringeItem extends Item {
    public SyringeItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(user.getStackInHand(hand).hasNbt()){
            NbtCompound nbtData = new NbtCompound();
            nbtData.putString("lostlifemod.savedData","Dodo");
            user.getStackInHand(hand).setNbt(nbtData);
        }
        else {
            NbtCompound nbtData = new NbtCompound();
            nbtData.putString("lostlifemod.savedData","Smilodon");
            user.getStackInHand(hand).setNbt(nbtData);
        }
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (stack.hasNbt() && entity instanceof InjectableEntity injectableEntity){
            String mob = stack.getNbt().getString("lostlifemod.savedData");
            injectableEntity.setInjectedMob(mob);
            user.sendMessage(Text.literal("Injected: "+mob));
            return ActionResult.SUCCESS;

        }
        return super.useOnEntity(stack, user, entity, hand);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            String savedData = stack.getNbt().getString("lostlifemod.savedData");
            tooltip.add(Text.literal(savedData));
        } else {
            tooltip.add(Text.literal("Unknown"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return stack.hasNbt();
    }

}
