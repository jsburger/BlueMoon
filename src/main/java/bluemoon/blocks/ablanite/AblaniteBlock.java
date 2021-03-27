package bluemoon.blocks.ablanite;

import bluemoon.registry.AllParticles;
import bluemoon.util.MiscHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class AblaniteBlock extends Block {
    public AblaniteBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        makeSparkle(stateIn, worldIn, pos, rand);
    }

    protected static void makeSparkle(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(5) == 0 ) {
            Vector3d particlePos = new Vector3d(pos.getX() + rand.nextFloat() * 1.2f, pos.getY() + rand.nextFloat() * 1.2f, pos.getZ() + rand.nextFloat() * 1.2f);
            MiscHelper.makeParticle(worldIn, AllParticles.ABLANITE_SPARKLE.get(), particlePos);
        }
    }

}
