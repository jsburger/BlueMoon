package bluemoon.core.registry;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

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
            .setLightLevel((state) -> 3);

    public static Block.Properties BRISTLEPINE() {
        return Block.Properties
                .create(Material.WOOD, MaterialColor.DIAMOND)
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.WOOD);
    }

}
