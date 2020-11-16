package bluemoon.core.registry.utility;

import bluemoon.core.registry.Registration;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;

import static bluemoon.core.registry.Registration.*;

public class DataRegistry {

     // Referenced from Atmospheric by Bageldotpng

    public static void setupRenderLayers() {

        RenderTypeLookup.setRenderLayer(       BRISTLEPINE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(POTTED_BRISTLEPINE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(   BRISTLEPINE_PLANKS.DOOR.get(), RenderType.getCutout());

    }

    public static void setupStrippables() {

        registerStrippable(BRISTLEPINE_LOG.get(), STRIPPED_BRISTLEPINE_LOG.get());
        registerStrippable(BRISTLEPINE_WOOD.get(), STRIPPED_BRISTLEPINE_WOOD.get());

    }

     // also referenced from atmospheric, fancy that.
    public static void registerStrippable(Block log, Block stripped) {
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(log, stripped);
    }

}
