package com.CiD.MysteryMod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import com.CiD.MysteryMod.Mobs.EntityChiGuard;
import com.CiD.MysteryMod.Render.RenderChiGuard;
import com.CiD.MysteryMod.Render.RenderGreenCrystal;
import com.CiD.MysteryMod.Render.RenderTileModelAsItem;
import com.CiD.MysteryMod.Render.TileModelRender;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.Render.RenderCable;
import com.CiD.MysteryMod.TecEvolution.Render.RenderCablePanel;
import com.CiD.MysteryMod.TecEvolution.Render.RenderColoredTile;
import com.CiD.MysteryMod.TecEvolution.Render.RenderConnections;
import com.CiD.MysteryMod.TecEvolution.Render.RenderTank;
import com.CiD.MysteryMod.TecEvolution.Render.RenderWindTurbine;
import com.CiD.MysteryMod.TecEvolution.Render.Item.RenderItemPaintModel;
import com.CiD.MysteryMod.TecEvolution.Render.Item.RenderScanner;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityBender;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCablePanel;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityColored;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityTank;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityWindTurbine;
import com.CiD.MysteryMod.TileEntity.TileEntityGreenCrystal;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class client extends common {

private static List<Class> tileColorClasslist = new ArrayList<Class>();

public static ResourceLocation TEXTUREmodel_white = new ResourceLocation(MysteryMain.MODID+":textures/model/model_white.png");

public static ResourceLocation MODELgreencrystal = new ResourceLocation(MysteryMain.MODID+":textures/model/greenCrystal.obj");
public static ResourceLocation MODELchiguard = new ResourceLocation(MysteryMain.MODID+":textures/model/Chi_Guard.obj");
public static ResourceLocation MODELwindturbin = new ResourceLocation(MysteryMain.MODID+":textures/model/windgenerator.obj");
public static ResourceLocation MODELbender = new ResourceLocation(MysteryMain.MODID+":textures/model/bender.obj");
public static ResourceLocation MODELfusionhull = new ResourceLocation(MysteryMain.MODID+":textures/model/fusionhull.obj");

		@SideOnly(Side.CLIENT)
		public void registerRenderThings(){
			

			
		  
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGreenCrystal.class, new RenderGreenCrystal(TEXTUREmodel_white, MODELgreencrystal));
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStorage.class, new RenderConnections());
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, new RenderCable());
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCablePanel.class, new RenderCablePanel());
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindTurbine.class, new RenderWindTurbine(TEXTUREmodel_white, MODELwindturbin));
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBender.class, new TileModelRender(TEXTUREmodel_white, MODELbender));
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTank.class, new RenderTank());
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityColored.class, new RenderColoredTile());

		  for(int i = 0; i<tileColorClasslist.size(); i++){
			  ClientRegistry.bindTileEntitySpecialRenderer(tileColorClasslist.get(i), new RenderColoredTile());
		  }
		  
		  RenderingRegistry.registerEntityRenderingHandler(EntityChiGuard.class, new RenderChiGuard(TEXTUREmodel_white, MODELchiguard));
		  
//			MinecraftForge.EVENT_BUS.register(new GUIexPlayer(Minecraft.getMinecraft()));
		  
		  
		  
		   MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MysteryMain.green_crystal), new RenderTileModelAsItem(MODELgreencrystal, TEXTUREmodel_white, new TileEntityGreenCrystal()));
		   MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TecEvolutionMain.iron_bender), new RenderTileModelAsItem(MODELbender, TEXTUREmodel_white, new TileEntityBender()));
		   MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TecEvolutionMain.wind_generator), new RenderTileModelAsItem(MODELwindturbin, TEXTUREmodel_white, new TileEntityWindTurbine()));
		   MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TecEvolutionMain.paint_model), new RenderItemPaintModel(TEXTUREmodel_white, null));
		   MinecraftForgeClient.registerItemRenderer(TecEvolutionMain.ink_scanner, new RenderScanner());

		}

		public static void addToIcolorTileList(Class<? extends TileEntity> tileClass){
			tileColorClasslist.add(tileClass);
		}
		
		@SideOnly(Side.CLIENT)
		public void registerSound() {
			MinecraftForge.EVENT_BUS.register(new MysteryMain());
		}
	
		public void registerHandlers()
		{
			
		}
		@Override
		public void registerPackets() {
				super.registerPackets();
			}
	
	
}
