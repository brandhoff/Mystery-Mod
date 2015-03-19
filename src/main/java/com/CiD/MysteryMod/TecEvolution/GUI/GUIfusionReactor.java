package com.CiD.MysteryMod.TecEvolution.GUI;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.client;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.GUI.BaseGUI;
import com.CiD.MysteryMod.Mobs.EntityChiGuard;
import com.CiD.MysteryMod.Network.packet.server.ShowParticlesFusionPacket;
import com.CiD.MysteryMod.TecEvolution.Buildcraft.RenderUtils;
import com.CiD.MysteryMod.TecEvolution.Factory.Containers.ContainerFusionReactor;
import com.CiD.MysteryMod.TecEvolution.Factory.TileEntity.TileEntityFusionReactor;

public class GUIfusionReactor extends BaseGUI{
private ResourceLocation slotGui = new ResourceLocation(MysteryMain.MODID+":textures/gui/GUItecSlot.png");
private TileEntityFusionReactor tile;
private InventoryPlayer inv;
private boolean showPrint = false;
private IModelCustom Model = (IModelCustom) AdvancedModelLoader.loadModel(client.MODELfusionhull);
private int rotation = 0;
private boolean show;

	public GUIfusionReactor(InventoryPlayer inventory, TileEntityFusionReactor tile) {
		super(new ContainerFusionReactor(inventory, tile));
		this.tile = tile;
		this.inv = inventory;
		show = tile.ShowParticles();
	}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			if(!showPrint)
				super.drawGuiContainerForegroundLayer(par1, par2);
		}
	
			@Override
			public void initGui() {
				buttonList = new ArrayList();
				super.initGui();
			    buttonList.add(new GuiButton(2, 20, 42 + 20, 90, 20, "Show Blue Print"));
			    buttonList.add(new GuiButton(3, 20, 42 + 40, 90, 20, "Show Particles"));

			}
	
		@Override
		protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
			if(showInfoContex){
		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		        this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/infoGUI.png"));
		    
		         drawTexturedModalRect(guiLeft, guiTop-40, 0, 0, 256, 256);
		         if(getInfo() != null){
		         String[] text = getInfo();
		         int lineNum = 0;
		         for(String line : text){
		        	 fontRendererObj.drawString(line, guiLeft+4, guiTop+20 + lineNum*10, 0x222222, false);
		        	 lineNum++;

		         }
		        }
		     }
			else if(showPrint){
				  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				   xSize = 512;
				   ySize = 512;

		              this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/fusion_blueprint_GUI.png"));
		              int x = (width - xSize) / 2;
		              int y = (height - ySize) / 2;
		              this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
			}else{
		    	 drawBackScreen(f,i,j);
		     }
		}
		
		@Override
			public void drawScreen(int par1, int par2, float f) {
			if(!showInfoContex && !showPrint)
				super.drawScreen(par1, par2, f);

			if(showPrint){
			
				drawGuiContainerBackgroundLayer(f, par1,par2);

			}
			if(showInfoContex){
				 for (int k = 0; k < this.buttonList.size(); ++k)
		         {
		             GuiButton guibutton = (GuiButton)this.buttonList.get(k);
		             guibutton.drawButton(this.mc, par1, par2);

		         }	
				drawGuiContainerBackgroundLayer(f, par1,par2);

			}
			
			
			
			if(showPrint && !showInfoContex){
				 for (int k = 0; k < this.buttonList.size(); ++k)
		         {
		             GuiButton guibutton = (GuiButton)this.buttonList.get(k);
		             guibutton.drawButton(this.mc, par1, par2);

		         }	
				
				rotation++;
				if(rotation >= 360){
					rotation = 0;
				}
				int xPos = (this.width - this.guiLeft) / 2;
				int yPos = (this.height - this.guiTop) / 2;

				//BY SanAndreasP http://www.minecraftforge.net/forum/index.php?topic=2434.0
				//Changed to render a .obj-File
				GL11.glPushMatrix();
				

				GL11.glPushMatrix();
				GL11.glTranslatef(xPos + 75, yPos + 100, 90F);
				float f1 = 30F;
				GL11.glScalef(-f1, f1, f1);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
				RenderHelper.enableStandardItemLighting();
				GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F);
				GL11.glColor3f(0.1F, 0.3F, 0.7F);
				

				GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
				
	            this.mc.renderEngine.bindTexture(client.TEXTUREmodel_white);
	            ((IModelCustom) Model).renderAll();
				GL11.glPopMatrix();
				RenderHelper.disableStandardItemLighting();
				GL11.glTranslatef(0F, 0F, 0.0F);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				int i1 = 240;
				int k1 = 240;
				OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
						i1 / 1.0F, k1 / 1.0F);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderHelper.disableStandardItemLighting();
				GL11.glPopMatrix();
			}
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
				"in a generator directly, it's a highly unstable"," fluid and every creature will make it explode",
				"","IF YOU NEED HELP CREATING THE HULL"," PRESS SHOW-BLUEPRINT"
				
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
		case 3:{
			if(show){
				show = false;
				MysteryMain.packetPipeline.sendToServer(new ShowParticlesFusionPacket(tile, show));
				break;
			}
			if(!show){
				show = true;
				MysteryMain.packetPipeline.sendToServer(new ShowParticlesFusionPacket(tile, show));
				break;
				}
			
		}
			}
		}
}
