package io.github.projectet.virtualore.blocks.entity;

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

    public oreBlockEntity(BlockEntityType<?> type) {
        super(type);
    }


    @Override
    public void fromClientTag(CompoundTag tag) {

    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        return null;
    }


    @Override
    public void fromTag(BlockState state, CompoundTag tag) {

    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
    return null;
    }

}

