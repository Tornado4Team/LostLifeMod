package net.llm.block.custom;

import net.llm.LostLifeMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class CleaningTableBlockEntity extends BlockEntity {
    public CleaningTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CLEANING_TABLE_BLOCK_ENTITY, pos, state);
    }

    private int number = 7;

    // Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound nbt) {
        // Save the current value of the number to the nbt
        nbt.putInt("number", number);

        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        number = nbt.getInt("number");
    }

}
