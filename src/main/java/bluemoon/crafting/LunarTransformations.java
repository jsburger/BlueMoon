package bluemoon.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import java.util.Optional;

public class LunarTransformations {

    public static class TransformationInv extends RecipeWrapper {
        public TransformationInv() {
            super(new ItemStackHandler(1));
        }
    }

    public static TransformationInv transformationInv = new TransformationInv();

    private static Optional<TransformationRecipe> getRecipe(ItemStack item, World world) {
        transformationInv.setInventorySlotContents(0, item);
        return TransformationRecipe.TYPE.find(transformationInv, world);
    }

    public static boolean isTransformable(ItemStack item, World world) {
        return getRecipe(item, world).isPresent();
    }

    public static ItemStack getTransformedItem(ItemStack itemIn, World world) {
        Optional<TransformationRecipe> recipe = getRecipe(itemIn, world);
//        if (recipe.isPresent()) {
//            return recipe.get().getCraftingResult(transformationInv);
//        }
//        return null;
        //intellij decided it could replace the above with this, kinda nuts
        return recipe.map(transformationRecipe -> transformationRecipe.getCraftingResult(transformationInv)).orElse(null);
    }

    public static boolean tryTransformBlock(BlockPos pos, World world) {
        Item item = world.getBlockState(pos).getBlock().asItem();
        Optional<TransformationRecipe> transformed = getRecipe(new ItemStack(item, 1), world);
        if (transformed.isPresent()) {
            Block new_block = transformed.get().getBlock();
            world.setBlockState(pos, new_block.getDefaultState());
            return true;
        }
        return false;
    }
}
