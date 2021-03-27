package bluemoon.registry;

import bluemoon.BlueMoon;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BlueMoon.MOD_ID);

    public static final RegistryObject<BasicParticleType> ABLANITE_SPARKLE = PARTICLE_TYPES.register("ablanite_sparkle", () ->
            new BasicParticleType(false));

}
