package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BowThing extends Item{

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		FlamingArrow f = new FlamingArrow(worldIn,playerIn,2.0F);
		f.setVelocity(f.motionX*3, f.motionY*3, f.motionZ*3);
		if(!worldIn.isRemote)
		{
		worldIn.spawnEntityInWorld(f);
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	

}
