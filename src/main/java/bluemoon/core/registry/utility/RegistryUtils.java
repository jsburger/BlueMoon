package bluemoon.core.registry.utility;


import bluemoon.core.registry.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class RegistryUtils {


    public static <BlockClass extends Block> RegistryObject<BlockClass> createBlock(String name, Supplier<? extends BlockClass> supplier) {
        return createBlock(name, supplier, Registration.BLOCK_GROUP);
    }

    // Copied/referenced/appropriated from Atmospheric by Bageldotpng
    public static <BlockClass extends Block> RegistryObject<BlockClass> createBlock(String name, Supplier<? extends BlockClass> supplier, ItemGroup group) {
        RegistryObject<BlockClass> block = Registration.BLOCKS.register(name, supplier);
        Registration.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group)));
        return block;
    }

}
