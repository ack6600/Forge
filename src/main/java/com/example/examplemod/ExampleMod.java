package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	Item bow = new BowThing();
    	Block blockbreak = new BlockBreaker(Material.piston);
    	GameRegistry.registerItem(bow, "bow");
    	bow.setCreativeTab(CreativeTabs.tabCombat);
    	
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderitem = Minecraft.getMinecraft().getRenderItem();
    		renderitem.getItemModelMesher().register(Item.getItemFromBlock(blockbreak), 0, new ModelResourceLocation(MODID+":"+((BlockBreaker) blockbreak).getName(),"inventory"));
    	}
    	
    }
}
