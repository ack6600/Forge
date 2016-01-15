package com.example.examplemod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockBreaker extends Block{
	
	BlockPos blockPos;
	Boolean isAdded;
	World world;
	TileEntityChest chest;
	Item itemToAdd;
	Boolean isFinished;
	Boolean isLoaded = false;
	private final String name = "blockbreaker";
	public BlockBreaker(Material materialIn) {
		super(materialIn);
		GameRegistry.registerBlock(this, name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName(name);
		


		
		// TODO Auto-generated constructor stub
	}
	public String getName()
	{
		return name;
	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		isAdded = true;
		world = worldIn;
		worldIn.scheduleUpdate(pos, this, 2);
		super.onBlockAdded(worldIn, pos, state);
		
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		blockPos = pos;
		world = worldIn;
//		System.out.println(blockPos);
//		System.out.println(blockPos.add(-1, 0, 0));
//		System.out.println(worldIn.getBlockState(blockPos.add(-1, 0, 0)));
//		System.out.println(world.getBlockState(blockPos.add(-1, 0, 0)).getBlock().getMaterial());
		if(blockPos.add(-1, 0, 0) != null)
		{
		if(worldIn.getBlockState(blockPos.add(-1, 0, 0)) != null)
		{
		if(world.getBlockState(blockPos.add(-1, 0, 0)).getBlock().getMaterial() != Material.air)
		{
			itemToAdd = Item.getItemFromBlock(world.getBlockState(blockPos.add(-1, 0, 0)).getBlock());
			world.destroyBlock(blockPos.add(-1, 0, 0), false);
			if(world.getBlockState(blockPos.up()).getBlock() == Blocks.chest)
			{
				chest = (TileEntityChest) world.getTileEntity(blockPos.up());
				isFinished = false;
				for(int i = 0;i<27 && !isFinished;i++)
				{
					if(chest.getStackInSlot(i) != null)
					{
						if(chest.getStackInSlot(i).getItem() == itemToAdd)
						{
							chest.setInventorySlotContents(i, new ItemStack(itemToAdd, chest.getStackInSlot(i).stackSize+1));
							isFinished = true;
						}
					}
					else
					{
						chest.setInventorySlotContents(i, new ItemStack(itemToAdd,1));
						isFinished = true;
					}
				}
			}
		}
		if(world.getBlockState(blockPos.add(1, 0, 0)).getBlock().getMaterial() != Material.air)
		{
			itemToAdd = Item.getItemFromBlock(world.getBlockState(blockPos.add(1, 0, 0)).getBlock());
			world.destroyBlock(blockPos.add(1, 0, 0), false);
			if(world.getBlockState(blockPos.up()).getBlock() == Blocks.chest)
			{
				chest = (TileEntityChest) world.getTileEntity(blockPos.up());
				isFinished = false;
				for(int i = 0;i<27 && !isFinished;i++)
				{
					if(chest.getStackInSlot(i) != null)
					{
						if(chest.getStackInSlot(i).getItem() == itemToAdd)
						{
							chest.setInventorySlotContents(i, new ItemStack(itemToAdd, chest.getStackInSlot(i).stackSize+1));
							isFinished = true;
						}
					}
					else
					{
						chest.setInventorySlotContents(i, new ItemStack(itemToAdd,1));
						isFinished = true;
					}
				}
			}
		}
		if(world.getBlockState(blockPos.add(0, 0, 1)).getBlock().getMaterial() != Material.air)
		{
			itemToAdd = Item.getItemFromBlock(world.getBlockState(blockPos.add(0, 0, 1)).getBlock());
			world.destroyBlock(blockPos.add(0, 0, 1), false);
			if(world.getBlockState(blockPos.up()).getBlock() == Blocks.chest)
			{
				chest = (TileEntityChest) world.getTileEntity(blockPos.up());
				isFinished = false;
				for(int i = 0;i<27 && !isFinished;i++)
				{
					if(chest.getStackInSlot(i) != null)
					{
						if(chest.getStackInSlot(i).getItem() == itemToAdd)
						{
							chest.setInventorySlotContents(i, new ItemStack(itemToAdd, chest.getStackInSlot(i).stackSize+1));
							isFinished = true;
						}
					}
					else
					{
						chest.setInventorySlotContents(i, new ItemStack(itemToAdd,1));
						isFinished = true;
					}
				}
			}
		}
		if(world.getBlockState(blockPos.add(0, 0, -1)).getBlock().getMaterial() != Material.air)
		{
			itemToAdd = Item.getItemFromBlock(world.getBlockState(blockPos.add(0, 0, -1)).getBlock());
			world.destroyBlock(blockPos.add(0, 0, -1), false);
			if(world.getBlockState(blockPos.up()).getBlock() == Blocks.chest)
			{
				chest = (TileEntityChest) world.getTileEntity(blockPos.up());
				isFinished = false;
				for(int i = 0;i<27 && !isFinished;i++)
				{
					if(chest.getStackInSlot(i) != null)
					{
						if(chest.getStackInSlot(i).getItem() == itemToAdd)
						{
							chest.setInventorySlotContents(i, new ItemStack(itemToAdd, chest.getStackInSlot(i).stackSize+1));
							isFinished = true;
						}
					}
					else
					{
						chest.setInventorySlotContents(i, new ItemStack(itemToAdd,1));
						isFinished = true;
					}
				}
			}
		}
		}
		}
		worldIn.scheduleUpdate(pos, this, 2);
		isLoaded=true;
		super.updateTick(worldIn, pos, state, rand);
	
	}

}
