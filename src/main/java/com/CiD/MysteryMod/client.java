package com.CiD.MysteryMod;

import com.CiD.MysteryMod.GUI.GUIexPlayer;
import com.CiD.MysteryMod.Mobs.EntityChiGuard;
import com.CiD.MysteryMod.Render.RenderChiGuard;
import com.CiD.MysteryMod.Render.RenderGreenCrystal;
import com.CiD.MysteryMod.TecEvolution.Render.RenderConnections;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;
import com.CiD.MysteryMod.TileEntity.TileEntityGreenCrystal;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class client extends common {
public static ResourceLocation TEXTUREmodel_white = new ResourceLocation(MysteryMain.MODID+":textures/model/model_white.png");

public static ResourceLocation MODELgreencrystal = new ResourceLocation(MysteryMain.MODID+":textures/model/greenCrystal.obj");
public static ResourceLocation MODELchiguard = new ResourceLocation(MysteryMain.MODID+":textures/model/Chi_Guard.obj");

	@SideOnly(Side.CLIENT)
		public void registerRenderThings(){
			


		  
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGreenCrystal.class, new RenderGreenCrystal(TEXTUREmodel_white, MODELgreencrystal));
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStorage.class, new RenderConnections());

		  
		  
		  RenderingRegistry.registerEntityRenderingHandler(EntityChiGuard.class, new RenderChiGuard(TEXTUREmodel_white, MODELchiguard));
		  
			MinecraftForge.EVENT_BUS.register(new GUIexPlayer(Minecraft.getMinecraft()));

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
