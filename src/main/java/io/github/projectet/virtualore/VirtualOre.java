package io.github.projectet.virtualore;

import io.github.projectet.virtualore.blocks.entity.oreBlockEntity;
import io.github.projectet.virtualore.blocks.oreBlock;
import io.github.projectet.virtualore.util.BlockEvents;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

    public static final Block TEST_BLOCK = new oreBlock(FabricBlockSettings.copyOf(Blocks.STONE).breakByTool(FabricToolTags.PICKAXES));
    public static final BlockEntityType<oreBlockEntity> ORE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, id("ore_block_entity"), BlockEntityType.Builder.create(oreBlockEntity::new, TEST_BLOCK).build(null));

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        Registry.register(Registry.BLOCK, id("test_block"), TEST_BLOCK);
        Registry.register(Registry.ITEM, id("test_block"), new BlockItem(TEST_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        BlockEvents.Initialise();

    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}