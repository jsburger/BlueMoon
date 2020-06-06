package com.jsburg.bluemoon.registry;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

//naming scheme and general idea lifted from Create by simibubi
public class SharedProperties {

    public static final Block.Properties MOONSTONE = Block.Properties
            .create(Material.ROCK, MaterialColor.QUARTZ)
            .hardnessAndResistance(1.5F, 6.0F);

    public static Block.Properties BRISTLEPINE() {
        return Block.Properties
                .create(Material.WOOD, MaterialColor.DIAMOND)
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.WOOD);
    }

}
