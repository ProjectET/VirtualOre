package io.github.projectet.virtualore.blocks.entity;

import io.github.projectet.virtualore.VirtualOre;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class oreBlockEntity extends BlockEntity implements BlockEntityClientSerializable {

    private int yield;

    public oreBlockEntity(BlockPos pos, BlockState state) {
        super(VirtualOre.ORE_BLOCK_ENTITY, pos, state);
        Random random = new Random();
        yield = random.nextInt(48) + 2;
    }

    @Override
    public void fromClientTag(NbtCompound tag) {
        readNbt(tag);
    }

    public int getYield() {
        return yield;
    }


    @Override
    public NbtCompound toClientTag(NbtCompound tag) {
        return this.writeNbt(tag);
    }

    public void decYield() {
        if (yield >= 2) {
            yield--;
        }
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        yield = tag.getInt("yield");
    }

    @Override
    public NbtCompound writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.putInt("yield", yield);
        return tag;
    }

}

