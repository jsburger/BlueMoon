package bluemoon.events;

import bluemoon.BlueMoon;
import bluemoon.particles.AblaniteSparkleParticle;
import bluemoon.registry.AllParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlueMoon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
        ParticleManager manager = Minecraft.getInstance().particles;
        manager.registerFactory(AllParticles.ABLANITE_SPARKLE.get(), AblaniteSparkleParticle.Factory::new);
    }

}
