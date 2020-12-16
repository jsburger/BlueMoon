package bluemoon.core;

import bluemoon.core.crafting.TransformationRecipe;
import bluemoon.core.registry.utility.DataRegistry;
import bluemoon.core.registry.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("blue_moon")
public class BlueMoon {

    public static final String MOD_ID = "blue_moon";


    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public BlueMoon() {


        Registration.register();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addGenericListener(IRecipeSerializer.class, this::registerRecipeSerializers);

    }

    private void setup(final FMLCommonSetupEvent event) {
        DataRegistry.setupStrippables();
    }

    void registerRecipeSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
        //Register the recipe type
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(TransformationRecipe.TYPE.toString()), TransformationRecipe.TYPE);
        //Register the serializer
        event.getRegistry().register(TransformationRecipe.SERIALIZER);
    }


    private void doClientStuff(final FMLClientSetupEvent event) {
        DataRegistry.setupRenderLayers();
    }

}
