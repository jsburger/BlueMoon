package bluemoon.registry.utility;


import bluemoon.registry.AllBlocks;
import bluemoon.registry.AllItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class RegistryUtils {


    public static <BlockClass extends Block> RegistryObject<BlockClass> createBlock(String name, Supplier<? extends BlockClass> supplier) {
        return createBlock(name, supplier, AllBlocks.BLOCK_GROUP);
    }

    // Copied/referenced/appropriated from Atmospheric by Bageldotpng
    public static <BlockClass extends Block> RegistryObject<BlockClass> createBlock(String name, Supplier<? extends BlockClass> supplier, ItemGroup group) {
        RegistryObject<BlockClass> block = AllBlocks.BLOCKS.register(name, supplier);
        AllItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group)));
        return block;
    }

}
