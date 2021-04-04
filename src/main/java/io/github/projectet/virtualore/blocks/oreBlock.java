package io.github.projectet.virtualore.blocks;

import io.github.projectet.virtualore.blocks.entity.oreBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import io.github.projectet.virtualore.VirtualOre;


public class oreBlock extends Block implements BlockEntityProvider {

    public oreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new oreBlockEntity(VirtualOre.ORE_BLOCK_ENTITY);
    }

}
