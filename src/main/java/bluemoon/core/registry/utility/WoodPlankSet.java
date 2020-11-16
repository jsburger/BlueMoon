package bluemoon.core.registry.utility;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;

import static net.minecraft.block.material.Material.MISCELLANEOUS;

public class WoodPlankSet extends StoneBlockSet {
    public RegistryObject<Block> FENCE;
    public RegistryObject<Block> FENCE_GATE;
    public RegistryObject<Block> PRESSURE_PLATE;
    public RegistryObject<Block> BUTTON;
    public RegistryObject<Block> DOOR;
    public RegistryObject<Block> TRAPDOOR;

    public WoodPlankSet(RegistryObject<Block> base_block) {
        super(base_block);
    }
    private Block.Properties properties() {
        return Block.Properties.from(BLOCK.get());
    }


    public StoneBlockSet addAll() {
        this.addSlabs();
        this.addStairs();
        FENCE      = RegistryUtils.createBlock(material_name + "_fence",      () -> new FenceBlock(properties()));
        FENCE_GATE = RegistryUtils.createBlock(material_name + "_fence_gate", () -> new FenceGateBlock(properties()));
        BUTTON     = RegistryUtils.createBlock(material_name + "_button",     () -> new WoodButtonBlock(AbstractBlock.Properties.create(MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5f)));
        DOOR       = RegistryUtils.createBlock(material_name + "_door",       () -> new DoorBlock(properties().notSolid()));
        TRAPDOOR   = RegistryUtils.createBlock(material_name + "_trapdoor",   () -> new TrapDoorBlock(properties().notSolid()));
        PRESSURE_PLATE = RegistryUtils.createBlock(material_name + "_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                properties().doesNotBlockMovement().hardnessAndResistance(0.5f)));
        return this;
    }


}
