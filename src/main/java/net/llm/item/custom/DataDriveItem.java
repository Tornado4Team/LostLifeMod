package net.llm.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DataDriveItem extends Item {
    public DataDriveItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(user.getStackInHand(hand).hasNbt()){
            user.getStackInHand(hand).setNbt(new NbtCompound());
        }
        else {
            NbtCompound nbtData = new NbtCompound();
            nbtData.putString("lostlifemod.savedData","Smilodon");
            user.getStackInHand(hand).setNbt(nbtData);
        }
        return super.use(world, user, hand);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            String savedData = stack.getNbt().getString("lostlifemod.savedData");
            tooltip.add(Text.literal("Saved data: "+savedData));
        } else {
            tooltip.add(Text.literal("Empty data drive"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return stack.hasNbt();
    }

}
