package io.github.projectet.virtualore.blocks.entity;

import io.github.projectet.virtualore.VirtualOre;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;

/*
TODO: Remember to use the PlayerBlockBreakEvents from net.fabricmc.fabric.api.event.player;
TODO: Consider using ActionResult in conjunction with the event.
TODO: Consider using BlockStates for storing the int of the yield or consider using Cardinal components.
*/

public class oreBlockEntity extends BlockEntity implements BlockEntityClientSerializable {

    private int yield;
    private BlockState blockState;


    public oreBlockEntity(BlockEntityType<?> type) {
        super(type);
    }

    public oreBlockEntity() {
        this(VirtualOre.ORE_BLOCK_ENTITY);
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        assert world != null;
        fromTag(world.getBlockState(pos), tag);
    }

    public BlockState getBlockState() {
        return blockState;
    }

    public int getYield() {
        return yield;
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        if(blockState != null) {
            tag.putInt("yield", yield);
        }
        return tag;
    }

    public int decYield() {
        if (getYield() >= 2) {
            return yield--;
        }
        else {
            return yield;
        }
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        yield = tag.getInt("yield");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        if(blockState != null) {
            tag.putInt("yield", yield);
        }
        super.toTag(tag);
        return tag;
    }

}

