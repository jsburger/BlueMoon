package bluemoon.crafting;

import bluemoon.BlueMoon;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

public class TransformationRecipe implements IRecipe<IInventory> {

    public static final Serializer SERIALIZER = new Serializer();
    public static TransformationRecipe.RecipeType TYPE = new RecipeType();

    private final Ingredient input;
    private final ItemStack output;
    private final Block block_output;
    private final ResourceLocation id;

    public TransformationRecipe(ResourceLocation id, Ingredient input, ItemStack output, Block block) {
        this.input = input;
        this.output = output;
        this.id = id;
        this.block_output = block;
    }

    public Ingredient getInput() {
        return this.input;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.input.test(inv.getStackInSlot(0));
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return this.getRecipeOutput().copy();
    }

    public Block getBlock() {
        return this.block_output;
    }

    @Override
    public boolean canFit(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType() {
        return TransformationRecipe.TYPE;
    }

    private static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<TransformationRecipe> {

        Serializer() {
            this.setRegistryName(new ResourceLocation(BlueMoon.MOD_ID, "transformation"));
        }

        @Nonnull
        @Override
        public TransformationRecipe read(ResourceLocation recipeId, JsonObject json) {

            final JsonElement inputElement = JSONUtils.isJsonArray(json, "ingredient") ?
                    JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient");
            final Ingredient input = Ingredient.deserialize(inputElement);
            final JsonObject out_json = JSONUtils.getJsonObject(json, "result");
            final ItemStack output = ShapedRecipe.deserializeItem(out_json);
             //Get a copy of the output as a block to use for placement.
            final ResourceLocation blockId = new ResourceLocation(JSONUtils.getString(out_json, "item"));
            final Block block = ForgeRegistries.BLOCKS.getValue(blockId);

            return new TransformationRecipe(recipeId, input, output, block);
        }

        @Nullable
        @Override
        public TransformationRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {

            final Ingredient input = Ingredient.read(buffer);
            final ItemStack output = buffer.readItemStack();
            final Block block = ForgeRegistries.BLOCKS.getValue(buffer.readResourceLocation());

            return new TransformationRecipe(recipeId, input, output, block);
        }

        @Override
        public void write(PacketBuffer buffer, TransformationRecipe recipe) {
            recipe.input.write(buffer);
            buffer.writeItemStack(recipe.output);
            buffer.writeResourceLocation(Objects.requireNonNull(recipe.block_output.getRegistryName()));
        }
    }

    public static class RecipeType implements IRecipeType<TransformationRecipe> {

        @Override
        public String toString() {
            return BlueMoon.MOD_ID + ":transformation";
        }

        public <C extends IInventory> Optional<TransformationRecipe> find(C inv, World world) {
            return world.getRecipeManager()
                    .getRecipe(TransformationRecipe.TYPE, inv, world);
        }
    }
}
