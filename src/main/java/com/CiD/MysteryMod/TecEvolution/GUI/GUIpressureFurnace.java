package com.CiD.MysteryMod.TecEvolution.GUI;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerPressureFurnace;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityPressureFurnace;



public class GUIpressureFurnace extends GuiContainer {

	private ResourceLocation slotGui = new ResourceLocation(MysteryMain.MODID+":textures/gui/GUItecSlot.png");
    private TileEntityPressureFurnace tile;   
	public GUIpressureFurnace (InventoryPlayer inventoryPlayer,
			TileEntityPressureFurnace tileEntity) {
                super(new ContainerPressureFurnace(inventoryPlayer, tileEntity));
                tile = tileEntity;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
               int energy = tile.getMomEnergy();
               int MAXenergy = tile.getMaxEnergy();
               int burningtime = (tile.getMAxBurningTime() - tile.getBurningTime())/20;
               int MAXburningtime = (tile.getMAxBurningTime())/20;

//                fontRendererObj.drawString("Machine", 8, 6, 4210752);
//                fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize + 2, 4210752);
                fontRendererObj.drawString("Energy: "+energy+"/"+MAXenergy, 8, ySize-102, 4210752);
                if(tile.energyPerTick() >= tile.getMomEnergy()){
                fontRendererObj.drawString("EnergyNeeded per Tick: "+tile.energyPerTick(), 8, ySize-110, 0x990000);
                }else{
                    fontRendererObj.drawString("EnergyNeeded per Tick: "+tile.energyPerTick(), 8, ySize-110, 0x009900);

                }
                fontRendererObj.drawString("Burning-Progress: "+burningtime+"/"+MAXburningtime,8, 6, 4210752);

        }
        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
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
}