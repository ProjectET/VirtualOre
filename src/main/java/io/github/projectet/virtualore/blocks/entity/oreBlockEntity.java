package io.github.projectet.virtualore.blocks.entity;

import io.github.projectet.virtualore.VirtualOre;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;

import java.util.Random;



public class oreBlockEntity extends BlockEntity implements BlockEntityClientSerializable {

    private int yield;

    public oreBlockEntity(BlockEntityType<?> type) {
        super(type);
    }

    public oreBlockEntity() {
        this(VirtualOre.ORE_BLOCK_ENTITY);
        Random random = new Random();
        yield = random.nextInt(48) + 2;
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        assert world != null;
        fromTag(world.getBlockState(pos), tag);
    }

    public int getYield() {
        return yield;
    }


    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        return this.toTag(tag);
    }

    public void decYield() {
        if (yield >= 2) {
            yield--;
        }
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        yield = tag.getInt("yield");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("yield", yield);
        return tag;
    }

}

