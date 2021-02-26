package bluemoon.core.registry.utility;

import bluemoon.core.registry.Registration;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;

import static bluemoon.core.registry.Registration.*;

public class DataRegistry {

    public static void setupRenderLayers() {

        RenderTypeLookup.setRenderLayer(       BRISTLEPINE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(POTTED_BRISTLEPINE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(   BRISTLEPINE_PLANKS.DOOR.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(       LIGHTSIDE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(POTTED_LIGHTSIDE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(   LIGHTSIDE_PLANKS.DOOR.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(       DARKSIDE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(POTTED_DARKSIDE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(   DARKSIDE_PLANKS.DOOR.get(), RenderType.getCutout());

    }

    public static void setupStrippables() {

        registerStrippable(BRISTLEPINE_LOG.get(), STRIPPED_BRISTLEPINE_LOG.get());
        registerStrippable(BRISTLEPINE_WOOD.get(), STRIPPED_BRISTLEPINE_WOOD.get());

        registerStrippable(LIGHTSIDE_LOG.get(), STRIPPED_LIGHTSIDE_LOG.get());
        registerStrippable(LIGHTSIDE_WOOD.get(), STRIPPED_LIGHTSIDE_WOOD.get());

        registerStrippable(DARKSIDE_LOG.get(), STRIPPED_DARKSIDE_LOG.get());
        registerStrippable(DARKSIDE_WOOD.get(), STRIPPED_DARKSIDE_WOOD.get());

    }

    public static void registerStrippable(Block log, Block stripped) {
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(log, stripped);
    }

}
