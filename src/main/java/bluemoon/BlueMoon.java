package bluemoon;

import bluemoon.crafting.TransformationRecipe;
import bluemoon.registry.AllBlocks;
import bluemoon.registry.AllItems;
import bluemoon.registry.AllParticles;
import bluemoon.registry.DataRegistry;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("blue_moon")
public class BlueMoon {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "blue_moon";


    public BlueMoon() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        AllBlocks.BLOCKS.register(modEventBus);
        AllItems.ITEMS.register(modEventBus);
        AllParticles.PARTICLE_TYPES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addGenericListener(IRecipeSerializer.class, this::registerRecipeSerializers);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        DataRegistry.setupStrippables();
    }

    void registerRecipeSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
        //Register the recipe type
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(TransformationRecipe.TYPE.toString()), TransformationRecipe.TYPE);
        //Register the serializer
        event.getRegistry().register(TransformationRecipe.SERIALIZER);
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        DataRegistry.setupRenderLayers();
    }

}
