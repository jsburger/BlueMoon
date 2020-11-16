package bluemoon.core.registry;

import bluemoon.core.registry.utility.WoodPlankSet;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.AcaciaTree;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static bluemoon.core.BlueMoon.MODID;
import static bluemoon.core.registry.utility.RegistryUtils.createBlock;

@SuppressWarnings("deprecation")
public class Registration {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

    // referenced in RegistrationUtil as the default item group
    public static final ItemGroup BLOCK_GROUP = ItemGroup.BUILDING_BLOCKS;

    //Blocks
     //Moonstone
    public static final RegistryObject<Block>                    MOONSTONE = createBlock("moonstone",                    () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>             MOONSTONE_BRICKS = createBlock("moonstone_bricks",             () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>     CRACKED_MOONSTONE_BRICKS = createBlock("cracked_moonstone_bricks",     () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>           CHISELED_MOONSTONE = createBlock("chiseled_moonstone",           () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>           BORDERED_MOONSTONE = createBlock("bordered_moonstone",           () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>          MOONSTONE_FLAGSTONE = createBlock("moonstone_flagstone",          () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block> BORDERED_MOONSTONE_FLAGSTONE = createBlock("bordered_moonstone_flagstone", () -> new Block(SharedProperties.MOONSTONE));



     //Bristlepine
    public static final RegistryObject<Block>        BRISTLEPINE_SAPLING = createBlock("bristlepine_sapling",        () -> new SaplingBlock(new AcaciaTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block>         BRISTLEPINE_LEAVES = createBlock("bristlepine_leaves",         () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block>            BRISTLEPINE_LOG = createBlock("bristlepine_log",            () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>   STRIPPED_BRISTLEPINE_LOG = createBlock("stripped_bristlepine_log",   () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.LAPIS).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>           BRISTLEPINE_WOOD = createBlock("bristlepine_wood",           () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>  STRIPPED_BRISTLEPINE_WOOD = createBlock("stripped_bristlepine_wood",  () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.LAPIS).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

    public static final WoodPlankSet BRISTLEPINE_PLANKS = new WoodPlankSet(createBlock("bristlepine_planks", () -> new Block(SharedProperties.BRISTLEPINE())));

    //Potted plants
     //Saplings
    public static final RegistryObject<Block> POTTED_BRISTLEPINE_SAPLING = BLOCKS.register("potted_bristlepine_sapling", () -> new FlowerPotBlock(BRISTLEPINE_SAPLING.get(), Block.Properties.from(Blocks.POTTED_AZURE_BLUET)));

}
