package bluemoon.registry.utility;

import net.minecraft.block.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ComplexStoneBlockSet extends StoneBlockSet {

    private final Function<AbstractBlock.Properties, ? extends Block> SLAB_CONSTRUCTOR;
    private final Function<AbstractBlock.Properties, ? extends Block> WALL_CONSTRUCTOR;
    private final BiFunction<Supplier<BlockState>, AbstractBlock.Properties, ? extends Block> STAIR_CONSTRUCTOR;

    public ComplexStoneBlockSet(RegistryObject<Block> base_block,
                                Function<AbstractBlock.Properties, ? extends Block> slabConstructor,
                                Function<AbstractBlock.Properties, ? extends Block> wallConstructor,
                                BiFunction<Supplier<BlockState>, AbstractBlock.Properties, ? extends Block> stairConstructor)
    {
        super(base_block, false);
        SLAB_CONSTRUCTOR = slabConstructor;
        WALL_CONSTRUCTOR = wallConstructor;
        STAIR_CONSTRUCTOR = stairConstructor;
        //This looks nasty but idk how to add this cleanly
        if (slabConstructor != null)
            this.addSlabs();
        if (wallConstructor != null)
            this.addWalls();
        if (stairConstructor != null)
            this.addStairs();

    }

    @Override
    public StoneBlockSet addSlabs() {
        if (SLAB_CONSTRUCTOR != null) {
            SLAB = RegistryUtils.createBlock(material_name + "_slab", () -> SLAB_CONSTRUCTOR.apply(properties()));
            return this;
        }
        return super.addSlabs();
    }

    @Override
    public StoneBlockSet addStairs() {
        if (STAIR_CONSTRUCTOR != null) {
            STAIRS = RegistryUtils.createBlock(material_name + "_stairs", () -> STAIR_CONSTRUCTOR.apply(() -> BLOCK.get().getDefaultState(), properties()));
            return this;
        }
        return super.addStairs();
    }

    @Override
    public StoneBlockSet addWalls() {
        if (WALL_CONSTRUCTOR != null) {
            WALL = RegistryUtils.createBlock(material_name + "_wall", () -> WALL_CONSTRUCTOR.apply(properties()), ItemGroup.DECORATIONS);
            return this;
        }
        return super.addWalls();
    }



}
