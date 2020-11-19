package bluemoon.common.block.trees;

import bluemoon.core.registry.Registration;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.LazyValue;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;
import java.util.Random;

public class BristlepineTree extends Tree {

    public final LazyValue<BaseTreeFeatureConfig> config;

    public BristlepineTree() {
        // config is lazy to let blocks register, though that might be fixable by not having the sapling register before logs
        config = new LazyValue<>(() ->
                (new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Registration.BRISTLEPINE_LOG.get().getDefaultState()),
                        new SimpleBlockStateProvider(Registration.BRISTLEPINE_LEAVES.get().getDefaultState()),
                        //Places round treetops: Thickness of bush             Height above wood?              Height of bush
                        //new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(2), 6),
                        //                     No apparent changes             Height above wood                    setting the first one to 6 breaks it
                        new PineFoliagePlacer(FeatureSpread.func_242252_a(1), FeatureSpread.func_242252_a(2), FeatureSpread.func_242253_a(3, 1)),
                        new StraightTrunkPlacer(5, 2, 1),
                        new TwoLayerFeature(2, 0, 2)))
                        .setIgnoreVines()
                        .build()
        );

    }

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random rand, boolean ThanksVazkii) {
        return Feature.TREE.withConfiguration(config.getValue());
    }


}
