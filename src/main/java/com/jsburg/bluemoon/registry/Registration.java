package com.jsburg.bluemoon.registry;

import com.jsburg.bluemoon.BlueMoon;
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


import static com.jsburg.bluemoon.BlueMoon.MODID;
import static com.jsburg.bluemoon.registry.RegistrationUtil.*;

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
    public static final RegistryObject<Block>                    MOONSTONE = registerBlock("moonstone",                    () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>             MOONSTONE_BRICKS = registerBlock("moonstone_bricks",             () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>     CRACKED_MOONSTONE_BRICKS = registerBlock("cracked_moonstone_bricks",     () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>           CHISELED_MOONSTONE = registerBlock("chiseled_moonstone",           () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>           BORDERED_MOONSTONE = registerBlock("bordered_moonstone",           () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block>          MOONSTONE_FLAGSTONE = registerBlock("moonstone_flagstone",          () -> new Block(SharedProperties.MOONSTONE));
    public static final RegistryObject<Block> BORDERED_MOONSTONE_FLAGSTONE = registerBlock("bordered_moonstone_flagstone", () -> new Block(SharedProperties.MOONSTONE));



     //Bristlepine
    public static final RegistryObject<Block>        BRISTLEPINE_SAPLING = registerBlock("bristlepine_sapling",        () -> new BlueMoonSaplingBlock(new AcaciaTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block>         BRISTLEPINE_LEAVES = registerBlock("bristlepine_leaves",         () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block>            BRISTLEPINE_LOG = registerBlock("bristlepine_log",            () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>   STRIPPED_BRISTLEPINE_LOG = registerBlock("stripped_bristlepine_log",   () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.LAPIS).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>           BRISTLEPINE_WOOD = registerBlock("bristlepine_wood",           () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BLACK).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block>  STRIPPED_BRISTLEPINE_WOOD = registerBlock("stripped_bristlepine_wood",  () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.LAPIS).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block>         BRISTLEPINE_PLANKS = registerBlock("bristlepine_planks",         () -> new Block(SharedProperties.BRISTLEPINE()));
    public static final RegistryObject<Block>           BRISTLEPINE_SLAB = registerBlock("bristlepine_slab",           () -> new SlabBlock(SharedProperties.BRISTLEPINE()));
    public static final RegistryObject<Block>         BRISTLEPINE_STAIRS = registerBlock("bristlepine_stairs",         () -> new StairsBlock(BRISTLEPINE_PLANKS.get()::getDefaultState, SharedProperties.BRISTLEPINE()));
    public static final RegistryObject<Block>          BRISTLEPINE_FENCE = registerBlock("bristlepine_fence",          () -> new FenceBlock(SharedProperties.BRISTLEPINE()));
    public static final RegistryObject<Block>     BRISTLEPINE_FENCE_GATE = registerBlock("bristlepine_fence_gate",     () -> new FenceGateBlock(SharedProperties.BRISTLEPINE()));
    public static final RegistryObject<Block>           BRISTLEPINE_DOOR = registerBlock("bristlepine_door",           () -> new BlueMoonDoorBlock(SharedProperties.BRISTLEPINE().notSolid()));
    public static final RegistryObject<Block>       BRISTLEPINE_TRAPDOOR = registerBlock("bristlepine_trapdoor",       () -> new BlueMoonTrapDoorBlock(SharedProperties.BRISTLEPINE().notSolid()));
    public static final RegistryObject<Block>         BRISTLEPINE_BUTTON = registerBlock("bristlepine_button",         () -> new BlueMoonWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BRISTLEPINE_PRESSURE_PLATE = registerBlock("bristlepine_pressure_plate", () -> new BlueMoonPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.DIAMOND).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));

    //Potted plants
     //Saplings
    public static final RegistryObject<Block> POTTED_BRISTLEPINE_SAPLING = BLOCKS.register("potted_bristlepine_sapling", () -> new FlowerPotBlock(BRISTLEPINE_SAPLING.get(), Block.Properties.from(Blocks.POTTED_AZURE_BLUET)));

}
