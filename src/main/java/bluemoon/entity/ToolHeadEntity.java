package bluemoon.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.world.World;

public class ToolHeadEntity extends FlyingEntity {

    protected ToolHeadEntity(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new FlyingMovementController(this, 8, false);
    }


}
