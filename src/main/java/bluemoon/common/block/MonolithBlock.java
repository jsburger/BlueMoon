package bluemoon.common.block;

import bluemoon.core.crafting.LunarTransformations;
import bluemoon.core.util.ShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Random;

@SuppressWarnings("deprecation")
public class MonolithBlock extends Block {
    public MonolithBlock(Properties properties) {
        super(properties);
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, 20);
         //TODO: Reduce radius during the day, increase radius with stacked monoliths, give height.
        List<BlockPos> places = ShapeHelper.getHorizontalCircularRegion(pos.down(), 3);
        for(BlockPos p: places) {
             //TODO: Collect all blocks that can be transformed, pick x random ones instead of random chance
            if (rand.nextBoolean()) {
                LunarTransformations.tryTransformBlock(p, worldIn);
            }
        }
    }

    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, 20);
    }

}