package io.github.projectet.virtualore;

import io.github.projectet.virtualore.blocks.entity.oreBlockEntity;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VirtualOre implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "virtualore";
    public static final String MOD_NAME = "Virtual Ore";

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    public static final BlockEntityType<oreBlockEntity> ORE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, id("oreBlockEntity"), BlockEntityType.Builder.create(oreBlockEntity::new, oreBlock));

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}