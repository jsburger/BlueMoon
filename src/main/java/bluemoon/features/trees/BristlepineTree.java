package bluemoon.features.trees;

import bluemoon.registry.Registration;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.Direction;
import net.minecraft.util.LazyValue;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeature;

import java.util.Random;

@SuppressWarnings("ConstantConditions")
public class BristlepineTree extends Tree {

    public final LazyValue<BaseTreeFeatureConfig> config;
    public final Feature<BaseTreeFeatureConfig> feature;

    public BristlepineTree() {
        // config is lazy to let blocks register, though that might be fixable by not having the sapling register before logs
        config = new LazyValue<>(() ->
                (new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Registration.BRISTLEPINE_LOG.get().getDefaultState()),
                        new SimpleBlockStateProvider(Registration.BRISTLEPINE_LEAVES.get().getDefaultState()),
//                        //Places round treetops: Thickness of bush             Height above wood?              Height of bush
//                        //new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(2), 6),
//                        //                     No apparent changes             Height above wood                    setting the first one to 6 breaks it
//                        new PineFoliagePlacer(FeatureSpread.func_242252_a(1), FeatureSpread.func_242252_a(2), FeatureSpread.func_242253_a(3, 1)),
//                        new StraightTrunkPlacer(5, 2, 1),
//                        new TwoLayerFeature(2, 0, 2)))
                        null,
                        null,
                        null))
                        .setIgnoreVines()
                        .build()
        );

        feature = new BristlepineTreeFeature(BaseTreeFeatureConfig.CODEC);


    }

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random rand, boolean ThanksVazkii) {
        return feature.withConfiguration(config.getValue());
    }

    public static class BristlepineTreeFeature extends Feature<BaseTreeFeatureConfig> {

        private static final BlockState TRUNK = Registration.BRISTLEPINE_LOG.get().getDefaultState();
        private static final BlockState LEAF = Registration.BRISTLEPINE_LEAVES.get().getDefaultState();
        public BristlepineTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
            super(codec);
        }

        @Override
        public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, BaseTreeFeatureConfig config) {
            // idk when this tree would be growing on anything but dirt but u know
            if (!isDirtAt(worldIn, pos.down())) {
                return false;
            }

            // the 1-wide spike of leaves on top
            int topSpikeHeight = 3;

            int minHeight = 5;
            int maxHeight = 8;
            int heightGoal = rand.nextInt(maxHeight - minHeight) + minHeight + topSpikeHeight;
            // starts at 1 because the first block is always a sapling
            float treeHeight = 1;
            BlockPos scanPos = pos.up();
            // get amount of available space directly above the tree
            while (TreeFeature.isAirOrLeavesAt(worldIn, scanPos) && treeHeight <= heightGoal && (scanPos.getY() + 1 <= worldIn.getHeight())) {
                treeHeight += isAirAt(worldIn, scanPos) ? 1 : .5;
                scanPos = scanPos.up();
            }
            int trunkHeight = (int)treeHeight - topSpikeHeight;
            if (trunkHeight <= minHeight - 2) {
                topSpikeHeight--;
                if (++trunkHeight <= 2) { return false; }
            }


            BlockPos trunkTop = pos;
            for (int i = 0; i < trunkHeight; i++) {
                trunkTop = pos.up(i);
                if (TreeFeature.isAirOrLeavesAt(worldIn, trunkTop)) {
                    setBlockState(worldIn, trunkTop, TRUNK);
                }
            }

            for (int i = 0; i < topSpikeHeight; i++) {
                ifAirSetBlock(worldIn, pos.up(i + trunkHeight), LEAF);
            }

            int groundSpace = trunkHeight >= minHeight + 1 ? 1 + rand.nextInt(2) : 1;
            int leafLayers = Math.min(6 + rand.nextInt(2), trunkHeight - groundSpace);
            int plusLayers = 2;
            int squareLayers = leafLayers - plusLayers;
            int roundLayers = squareLayers >= 3 ? 2: 0;

            int leafProgress = 0;
            while (plusLayers > 1) {
                plusLayers -= 1;
                makePlusLeafLayer(worldIn, trunkTop.down(leafProgress++));
            }
            for (int i = 0; i < squareLayers; i++) {
                makeSquareLeafLayer(worldIn, trunkTop.down(leafProgress + i));
            }
            for (int i = 0; i < roundLayers; i++) {
                BlockPos offset = trunkTop.down((int) (leafProgress + Math.ceil(((float) (squareLayers - roundLayers))/2) + i));
                makeRoundLeafLayer(worldIn, offset);
            }
            leafProgress += squareLayers;
            makePlusLeafLayer(worldIn, trunkTop.down(leafProgress));



            return true;
        }

        private void makePlusLeafLayer(ISeedReader worldIn, BlockPos startPos) {
            makePlusLeafLayer(worldIn, startPos, 1);
        }

        private void makePlusLeafLayer(ISeedReader worldIn, BlockPos startPos, int scale) {
            for (int i = 0; i < 4; i++) {
                ifAirSetBlock(worldIn, startPos.offset(Direction.byHorizontalIndex(i), scale), LEAF);
            }
        }

        private void makeSquareLeafLayer(ISeedReader worldIn, BlockPos startPos){
            for (int z = -1; z <= 1; z++) {
                for (int x = -1; x <= 1; x++) {
                    ifAirSetBlock(worldIn, startPos.add(x, 0, z), LEAF);
                }
            }
        }

        private void makeRoundLeafLayer(ISeedReader worldIn, BlockPos startPos) {
            makeSquareLeafLayer(worldIn, startPos);
            makePlusLeafLayer(worldIn, startPos, 2);
        }

        private void ifAirSetBlock(ISeedReader worldIn, BlockPos posIn, BlockState blockStateIn) {
            if (isAirAt(worldIn, posIn)) setBlockState(worldIn, posIn, blockStateIn);
        }
    }

}
