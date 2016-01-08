package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class FlamingArrow extends EntityArrow{

	public FlamingArrow(World w,EntityLivingBase e,float f) 
	{
		super(w,e,f);
		this.setDamage(0);
		this.setCustomNameTag("LASER");
		this.setAlwaysRenderNameTag(true);
	}

	@Override
	public void onEntityUpdate() {
		// TODO Auto-generated method stub
		if(this.isCollided)
		{
			Entity e = new EntityTNTPrimed(this.getEntityWorld());
			e.setPosition(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ());
			if(this.getEntityWorld().isRemote)
			{
				this.getEntityWorld().spawnEntityInWorld(e);
			}
			
		}
		super.onEntityUpdate();
	}

}
