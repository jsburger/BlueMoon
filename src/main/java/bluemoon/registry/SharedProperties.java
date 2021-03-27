package bluemoon.registry;


import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SharedProperties {

    public static final Block.Properties MOONSTONE = Block.Properties
            .create(Material.ROCK, MaterialColor.QUARTZ)
            .setRequiresTool()
            .hardnessAndResistance(1.5F, 6.0F);

    public static final AbstractBlock.Properties NEBULITE = AbstractBlock.Properties
            .create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
            .setRequiresTool().hardnessAndResistance(1.5F, 6.0F);

    public static final AbstractBlock.Properties ABLANITE = AbstractBlock.Properties
            .create(Material.ROCK, MaterialColor.WHITE_TERRACOTTA)
            .setRequiresTool().hardnessAndResistance(1.5F, 6.0F)
            .setLightLevel((state) -> 5)
            .notSolid();

    public static final AbstractBlock.Properties BRISTLEPINE = woodWithColor(MaterialColor.DIAMOND);
    public static final AbstractBlock.Properties LIGHTSIDE_OAK = woodWithColor(MaterialColor.SNOW);
    public static final AbstractBlock.Properties DARKSIDE_OAK = woodWithColor(MaterialColor.BROWN);

    private static AbstractBlock.Properties woodWithColor(MaterialColor color) {
        return AbstractBlock.Properties
                .create(Material.WOOD, color)
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.WOOD);
    }

    private static boolean needsPostProcessing(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

}
