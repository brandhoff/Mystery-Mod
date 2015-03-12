package com.CiD.MysteryMod.TecEvolution.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.GUI.BaseGUI;
import com.CiD.MysteryMod.TecEvolution.Factory.Containers.ContainerFusionReactor;
import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityFusionReactor;

public class GUIfusionReactor extends BaseGUI{
private ResourceLocation slotGui = new ResourceLocation(MysteryMain.MODID+":textures/gui/GUItecSlot.png");
private TileEntityFusionReactor tile;
private InventoryPlayer inv;
	public GUIfusionReactor(InventoryPlayer inventory, TileEntityFusionReactor tile) {
		super(new ContainerFusionReactor(inventory, tile));
		this.tile = tile;
		this.inv = inventory;
	}

	  @Override
      public void drawBackScreen(float par1, int par2,
                      int par3) {
		  
		  
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/BaseTecGUI.png"));
              int x = (width - xSize) / 2;
              int y = (height - ySize) / 2;
              this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
              drawSlots();
         
              
              
      }
      
      private void drawSlots(){
      	GL11.glPushMatrix();
      	
      	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          this.mc.renderEngine.bindTexture(this.slotGui);
          int x = (width - xSize) / 2;
          int y = (height - ySize) / 2;
          for (int i = 0; i < 1; i++) {
              for (int j = 0; j < 2; j++) {
              	this.drawTexturedModelRectFromIcon(x+30   + j * 18, y+17 + i * 18, BlockBase.GUI_TEC_SLOT, 16,16);
              }
          }
      	GL11.glPopMatrix();
      }

	@Override
	public String[] getInfo() {
		String[] text = {
				"This is the ultimate machine for creating energy"," and matter noone ever has seen before!",
				"Simply add two materials to the slots and give"," it 10.000.000 E/T (I know not much)",
				"And the Reactor will start producing plasma."," Plasma can be used in the matter-converter or",
				"in a generator directly, it's a highly unstable"," fluid and every creature will make it explode"
				
		};
		return text;
	}
}
