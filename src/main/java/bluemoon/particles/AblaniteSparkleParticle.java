package bluemoon.particles;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AblaniteSparkleParticle extends DeceleratingParticle {
    private final IAnimatedSprite spriteWithAge;

    protected AblaniteSparkleParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ, IAnimatedSprite sprite) {
        super(world, x, y, z, motionX, motionY, motionZ);
        this.maxAge = 8 + this.rand.nextInt(2);
        this.spriteWithAge = sprite;
        this.selectSpriteWithAge(sprite);
        this.particleScale = this.rand.nextFloat() * 0.1f + 0.1f;
    }


    @Override
    public void tick() {
        super.tick();
        if (!this.isExpired) {
            this.selectSpriteWithAge(this.spriteWithAge);
        }
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }

        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new AblaniteSparkleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.sprite);
        }
    }


}
