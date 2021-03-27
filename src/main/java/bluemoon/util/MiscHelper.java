package bluemoon.util;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;

public class MiscHelper {


    public static void makeParticle(World world, BasicParticleType particle, Vector3d position) {
        world.addParticle(particle, position.getX(), position.getY(), position.getZ(), 0, 0, 0);
    }

    public static void makeParticle(World world, BasicParticleType particle, Vector3d position, Vector3d motion, double speed) {
        motion = motion.normalize().scale(speed);
        world.addParticle(particle, position.getX(), position.getY(), position.getZ(), motion.getX(), motion.getY(), motion.getZ());
    }

}
