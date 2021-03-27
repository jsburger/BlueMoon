package bluemoon.blocks.ablanite;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class AblaniteSlabBlock extends SlabBlock {
    public AblaniteSlabBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        AblaniteBlock.makeSparkle(stateIn, worldIn, pos, rand);
    }

}
