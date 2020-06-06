package com.jsburg.bluemoon.registry;

import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;

//if you see this and shit your pants with fury, let me know, ill probably fix it
class BlueMoonSaplingBlock extends SaplingBlock {

    protected BlueMoonSaplingBlock(Tree treeIn, Properties properties) {
        super(treeIn, properties);
    }
}

class BlueMoonTrapDoorBlock extends TrapDoorBlock {

    protected BlueMoonTrapDoorBlock(Properties properties) {
        super(properties);
    }
}

class BlueMoonDoorBlock extends DoorBlock {

    protected BlueMoonDoorBlock(Properties builder) {
        super(builder);
    }
}

class BlueMoonWoodButtonBlock extends WoodButtonBlock {

    protected BlueMoonWoodButtonBlock(Properties properties) {
        super(properties);
    }
}

class BlueMoonPressurePlateBlock extends PressurePlateBlock {

    protected BlueMoonPressurePlateBlock(Sensitivity sensitivityIn, Properties propertiesIn) {
        super(sensitivityIn, propertiesIn);
    }
}