package io.github.projectet.virtualore.blocks;

import io.github.projectet.virtualore.blocks.entity.oreBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class oreBlock extends Block implements BlockEntityProvider {

    public oreBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(YIELDS, true));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof oreBlockEntity) {
                System.out.println("Before " + ((oreBlockEntity) blockEntity).getYield());
                ((oreBlockEntity) blockEntity).decYield();
                System.out.println("After " + ((oreBlockEntity) blockEntity).getYield());
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        if(!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof oreBlockEntity) {
                if(((oreBlockEntity) blockEntity).getYield() <= 1) {
                    System.out.println("I'm Broke");
                }
            }
        }
    }

    public static final BooleanProperty YIELDS = BooleanProperty.of("yields");

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new oreBlockEntity();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(YIELDS);
    }
}
