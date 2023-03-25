package net.llm.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.llm.LostLifeMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup LOSTLIFE;

    public static void registerItemGroups(){
        LOSTLIFE = FabricItemGroup.builder(new Identifier(LostLifeMod.MOD_ID, "lostlife"))
                .displayName(Text.literal("Lost Life"))
                .icon(()-> new ItemStack(ModItems.FOSSIL)).build();
    }
}
