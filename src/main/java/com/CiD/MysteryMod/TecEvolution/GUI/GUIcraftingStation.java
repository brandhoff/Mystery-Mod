package com.CiD.MysteryMod.TecEvolution.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.GUI.BaseGUI;
import com.CiD.MysteryMod.GUI.Book.GUImystBook;
import com.CiD.MysteryMod.TecEvolution.Factory.Containers.ContainerCraftingStation;
import com.CiD.MysteryMod.TecEvolution.Factory.MultiBlock.ITileMultiBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GUIcraftingStation extends BaseGUI
{

	private EntityPlayer user;
	private boolean showInfoContex = false;
	
public GUIcraftingStation(EntityPlayer player, InventoryPlayer inventoryplayer, World world, int i, int j, int k)
{		
         super(new ContainerCraftingStation(inventoryplayer, world, i, j, k));
         
         user = player;
}

		@Override
		public void initGui() {
			super.initGui();
		    buttonList.add(new GuiButton(2, 20, 72, 90, 20, "Crafting-Recipes"));

		}

		@Override
		public void onGuiClosed()
		{
			super.onGuiClosed();
		
		}
		@Override
			public void drawScreen(int par1, int par2, float p_73863_3_) {
			  for (int k = 0; k < this.buttonList.size(); ++k)
		         {
		             GuiButton guibutton = (GuiButton)this.buttonList.get(k);
		             guibutton.drawButton(this.mc, par1, par2);

		         }	
			  super.drawScreen(par1, par2, p_73863_3_);

			}
		
		
		@Override		
		protected void drawGuiContainerForegroundLayer(int par1, int par2)
		{
			super.drawGuiContainerForegroundLayer(par1, par2);
		         this.fontRendererObj.drawString(StatCollector.translateToLocal("\u00a76Better"), 120, 5, 0x404040);
		         this.fontRendererObj.drawString(StatCollector.translateToLocal("\u00a76Crafting"), 116, 20, 0x404040);
		
		       
		
		}
		@Override
		protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
			{
		         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		         this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/CraftingStationGUI.png"));
		         int l = (width - xSize) / 2;
		         int i1 = (height - ySize) / 2;
		         drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
			}

		
		@Override
			protected void actionPerformed(GuiButton button) {
				super.actionPerformed(button);
				
				switch(button.id){
		
				}
			}
		
}