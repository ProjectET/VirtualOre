package io.github.projectet.virtualore.util;

import io.github.projectet.virtualore.blocks.oreBlock;
import net.minecraft.item.Item;

public interface oreType {
    boolean enabled();
    Item getMineral();
    oreBlock getBlock();
    String getPath();


}
