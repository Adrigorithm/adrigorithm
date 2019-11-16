package com.adri.main.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
    @ObjectHolder("adrigorithm:firstblock")
    public static FirstBlock FIRSTBLOCK;

    @ObjectHolder("adrigorithm:firstblock")
    public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;
}
