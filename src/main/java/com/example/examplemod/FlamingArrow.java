package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class FlamingArrow extends EntityArrow{
	boolean b = false;
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
		if(!b)
		{
			BlockPos blockpos = new BlockPos(this.getPosition().getX(), this.getPosition().down().getY(), this.getPosition().getZ());
		    IBlockState iblockstate = this.worldObj.getBlockState(blockpos);
		    Block block = iblockstate.getBlock();
			if(block.getMaterial() != Material.air)
			{
				System.out.println("hello");
				Entity e = new EntityTNTPrimed(this.getEntityWorld());
				e.setPosition(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ());
				this.getEntityWorld().spawnEntityInWorld(e);
				b = true;
			}
		}
//		if(this.isCollided)
//		{
//			Entity e = new EntityTNTPrimed(this.getEntityWorld());
//			e.setPosition(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ());
//				this.getEntityWorld().spawnEntityInWorld(e);
//			
//		}
		super.onEntityUpdate();
	}

}
