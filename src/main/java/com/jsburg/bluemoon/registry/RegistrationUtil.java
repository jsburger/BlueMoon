package com.jsburg.bluemoon.registry;


import com.jsburg.bluemoon.BlueMoon;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class RegistrationUtil {


    public static <BlockClass extends Block> RegistryObject<BlockClass> registerBlock(String name, Supplier<? extends BlockClass> supplier) {
        return registerBlock(name, supplier, Registration.BLOCK_GROUP);
    }

    // Copied/referenced/appropriated from Atmospheric by Bageldotpng
    public static <BlockClass extends Block> RegistryObject<BlockClass> registerBlock(String name, Supplier<? extends BlockClass> supplier, ItemGroup group) {
        RegistryObject<BlockClass> block = Registration.BLOCKS.register(name, supplier);
        Registration.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group)));
        return block;
    }

}
