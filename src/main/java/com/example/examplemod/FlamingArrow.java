package com.example.examplemod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class FlamingArrow extends EntityArrow{

	public FlamingArrow(World w,EntityLivingBase e,float f) 
	{
		super(w,e,f);
		this.setDamage(0);
		this.setCustomNameTag("LASER");
		this.setAlwaysRenderNameTag(true);
		this.setVelocity(this.motionX*1.5, this.motionY*1.5, this.motionZ*1.5);
	}

}
