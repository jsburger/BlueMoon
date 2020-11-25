package bluemoon.core.registry;

import bluemoon.common.block.trees.BristlepineTree;
import bluemoon.core.registry.utility.StoneBlockSet;
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
     //Craterstone
    public static final StoneBlockSet CRATERSTONE = new StoneBlockSet(createBlock("craterstone", () -> new Block(SharedProperties.MOONSTONE)));
     //Moonstone
    public static final StoneBlockSet                    MOONSTONE = new StoneBlockSet(createBlock("moonstone",          () -> new Block(SharedProperties.MOONSTONE)));
    public static final StoneBlockSet             MOONSTONE_BRICKS = new StoneBlockSet(createBlock("moonstone_bricks",   () -> new Block(SharedProperties.MOONSTONE)));
    public static final RegistryObject<Block>     CRACKED_MOONSTONE_BRICKS = createBlock("cracked_moonstone_bricks",     () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>           CHISELED_MOONSTONE = createBlock("chiseled_moonstone",           () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>           BORDERED_MOONSTONE = createBlock("bordered_moonstone",           () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>          MOONSTONE_FLAGSTONE = createBlock("moonstone_flagstone",          () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block> BORDERED_MOONSTONE_FLAGSTONE = createBlock("bordered_moonstone_flagstone", () -> new Block(SharedProperties.MOONSTONE));
     //Nebulite
    public static final StoneBlockSet NEBULITE          = new StoneBlockSet(createBlock("nebulite", () -> new Block(SharedProperties.NEBULITE)));
    public static final StoneBlockSet POLISHED_NEBULITE = new StoneBlockSet(createBlock("polished_nebulite", () -> new Block(SharedProperties.NEBULITE)), false).addSlabs().addStairs();
     //Ablanite
    public static final StoneBlockSet ABLANITE          = new StoneBlockSet(createBlock("ablanite", () -> new Block(SharedProperties.ABLANITE)));
    public static final StoneBlockSet POLISHED_ABLANITE = new StoneBlockSet(createBlock("polished_ablanite", () -> new Block(SharedProperties.ABLANITE)));

     //Bristlepine
    public static final RegistryObject<Block>         BRISTLEPINE_LEAVES = createBlock("bristlepine_leaves",         () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block>            BRISTLEPINE_LOG = createBlock("bristlepine_log",            () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>        BRISTLEPINE_SAPLING = createBlock("bristlepine_sapling",        () -> new SaplingBlock(new BristlepineTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block>   STRIPPED_BRISTLEPINE_LOG = createBlock("stripped_bristlepine_log",   () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.LAPIS).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>           BRISTLEPINE_WOOD = createBlock("bristlepine_wood",           () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>  STRIPPED_BRISTLEPINE_WOOD = createBlock("stripped_bristlepine_wood",  () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.LAPIS).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> POTTED_BRISTLEPINE_SAPLING = createPottedPlant(BRISTLEPINE_SAPLING);

    public static final WoodPlankSet BRISTLEPINE_PLANKS = new WoodPlankSet(createBlock("bristlepine_planks", () -> new Block(SharedProperties.BRISTLEPINE())));

     //Lightside Oak
    public static final RegistryObject<Block>        LIGHTSIDE_SAPLING = createBlock("lightside_sapling",        () -> new SaplingBlock(new AcaciaTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block>         LIGHTSIDE_LEAVES = createBlock("lightside_leaves",         () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block>            LIGHTSIDE_LOG = createBlock("lightside_log",            () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>   STRIPPED_LIGHTSIDE_LOG = createBlock("stripped_lightside_log",   () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>           LIGHTSIDE_WOOD = createBlock("lightside_wood",           () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>  STRIPPED_LIGHTSIDE_WOOD = createBlock("stripped_lightside_wood",  () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> POTTED_LIGHTSIDE_SAPLING = createPottedPlant(LIGHTSIDE_SAPLING);

    public static final WoodPlankSet LIGHTSIDE_PLANKS = new WoodPlankSet(createBlock("lightside_planks", () -> new Block(SharedProperties.LIGHTSIDE_OAK)));

     //Darkside Oak
    public static final RegistryObject<Block>        DARKSIDE_SAPLING = createBlock("darkside_sapling",        () -> new SaplingBlock(new AcaciaTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block>         DARKSIDE_LEAVES = createBlock("darkside_leaves",         () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block>            DARKSIDE_LOG = createBlock("darkside_log",            () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>   STRIPPED_DARKSIDE_LOG = createBlock("stripped_darkside_log",   () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>           DARKSIDE_WOOD = createBlock("darkside_wood",           () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>  STRIPPED_DARKSIDE_WOOD = createBlock("stripped_darkside_wood",  () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> POTTED_DARKSIDE_SAPLING = createPottedPlant(DARKSIDE_SAPLING);

    public static final WoodPlankSet DARKSIDE_PLANKS = new WoodPlankSet(createBlock("darkside_planks", () -> new Block(SharedProperties.DARKSIDE_OAK)));


    private static RegistryObject<Block> createPottedPlant(RegistryObject<Block> plant) {
        String name = plant.getId().getPath();
        Block pot = new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), plant, Block.Properties.from(Blocks.POTTED_AZURE_BLUET));
        ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(plant.getId(), () -> pot);
        return BLOCKS.register("potted_" + name, () -> pot);
    }
}
