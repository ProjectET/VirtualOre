package io.github.projectet.virtualore.blocks;

import io.github.projectet.virtualore.blocks.blockEntities.oreBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class oreBlock extends Block implements BlockEntityProvider {

    public oreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new oreBlockEntity(oreBlockEntity.ORE_BLOCK_TYPE);
    }

}
