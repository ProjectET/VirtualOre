package io.github.projectet.virtualore.util;

import io.github.projectet.virtualore.blocks.entity.oreBlockEntity;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.text.LiteralText;

public class BlockEvents {

    public static void Initialise() {
        PlayerBlockBreakEvents.BEFORE.register(((world, player, pos, state, entity) -> {
            if (world.getBlockEntity(pos) instanceof oreBlockEntity) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if(((oreBlockEntity) blockEntity).getYield() >= 2) {
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                return true;
            }
        }));
        PlayerBlockBreakEvents.CANCELED.register(((world, player, pos, state, entity) -> {
            if (world.getBlockEntity(pos) instanceof oreBlockEntity) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if(player.getMainHandStack().isDamageable()) {
                    player.getMainHandStack().damage(1, player, null);
                }
                ((oreBlockEntity) blockEntity).decYield();
                player.sendMessage(new LiteralText("Yield: " + ((oreBlockEntity) blockEntity).getYield() + " Durability: " + (player.getMainHandStack().getMaxDamage() - player.getMainHandStack().getDamage())), true);
            }
        }));
    }
}
