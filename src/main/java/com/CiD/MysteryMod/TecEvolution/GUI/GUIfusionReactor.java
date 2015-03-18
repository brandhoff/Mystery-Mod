package com.CiD.MysteryMod.TecEvolution.GUI;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
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
private boolean showPrint = false;
	public GUIfusionReactor(InventoryPlayer inventory, TileEntityFusionReactor tile) {
		super(new ContainerFusionReactor(inventory, tile));
		this.tile = tile;
		this.inv = inventory;
	}

		@Override
			public void initGui() {
				buttonList = new ArrayList();
				super.initGui();
			    buttonList.add(new GuiButton(2, 20, 42 + 20, 90, 20, "Show Blue Print"));
			}
	
		@Override
		protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
//			if(!showPrint){
				super.drawGuiContainerBackgroundLayer(f, i, j);
//			}else{
//				drawBackScreen(f, i, j);
//			}
		}
		
		@Override
			public void drawScreen(int par1, int par2, float f) {
//			if(!showPrint){
				super.drawScreen(par1, par2, f);
//			}else{
//				drawBackScreen(f, par1, par2);
//			}
			}
		
		
	  @Override
      public void drawBackScreen(float par1, int par2,
                      int par3) {
		  
		  if(!showPrint){
			   /** The X size of the inventory window in pixels. */
			   xSize = 176;
			    /** The Y size of the inventory window in pixels. */
			   ySize = 166;
              GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
              this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/fusionGUI.png"));
              int x = (width - xSize) / 2;
              int y = (height - ySize) / 2;
              this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
              drawSlots();
		  }else{
			   GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			   xSize = 512;
			   ySize = 512;

	              this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/fusion_blueprint_GUI.png"));
	              int x = (width - xSize) / 2;
	              int y = (height - ySize) / 2;
	              this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		  }
              
              
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
				"Simply add two materials to the slots and give"," it 10.000.000 E/T (not much - I know)",
				"And the Reactor will start producing plasma."," Plasma can be used in the matter-converter or",
				"in a generator directly, it's a highly unstable"," fluid and every creature will make it explode"
				
		};
		return text;
	}
	
	
	@Override
		protected void actionPerformed(GuiButton button) {
		switch(button.id){
		case 1:{
				super.actionPerformed(button);
				}
		case 2:{

			if(showPrint){
				showPrint = false;
				break;
			}
			if(!showPrint){
				showPrint = true;
				break;
				}
		}
			}
		}
}
