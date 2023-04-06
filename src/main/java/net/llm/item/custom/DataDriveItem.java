package net.llm.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DataDriveItem extends Item {
    public DataDriveItem(Settings settings) {
        super(settings.maxDamage(100));
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack heldItem = user.getStackInHand(hand);

        if(user.getStackInHand(hand).hasNbt()){
            NbtCompound nbtData = new NbtCompound();
            nbtData.putString("lostlifemod.savedData","chomper");
            user.getStackInHand(hand).setNbt(nbtData);
        }
        else {
            NbtCompound nbtData = new NbtCompound();
            nbtData.putString("lostlifemod.savedData","chomper");
            user.getStackInHand(hand).setNbt(nbtData);
        }

        if (heldItem.isDamageable()) {
            int maxDamage = heldItem.getMaxDamage();
            int currentDamage = heldItem.getDamage();
            float durability = (float) (maxDamage - currentDamage) / maxDamage;
            heldItem.damage(1, user, (entity) -> entity.sendToolBreakStatus(hand));
            user.sendMessage(Text.literal(String.format("%.0f%%", durability * 100)));
        }
        return super.use(world, user, hand);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            String savedData = stack.getNbt().getString("lostlifemod.savedData");
            tooltip.add(Text.literal("Saved data: "+savedData +" "+ (stack.getMaxDamage()-stack.getDamage()) +"%"));
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
