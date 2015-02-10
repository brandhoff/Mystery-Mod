package com.CiD.MysteryMod.TecEvolution.GUI;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCablePanel;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityNuclearReactor;

public class GUIcablePanel extends GuiScreen {
	 /** The X size of the inventory window in pixels. */
    protected int xSize = 255;
    /** The Y size of the inventory window in pixels. */
    protected int ySize = 240;
    private TileEntityCablePanel tile;
		public GUIcablePanel(TileEntity tile) {
			this.tile = (TileEntityCablePanel) tile;
		}

       
       
        @Override
        public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
        	
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/CablePanelGUI.png"));
            int x = (width - xSize) /2;
            int y = (height - ySize)/2;
            this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        	
        	if(tile != null && tile.getNetwork() != null && tile.getNetwork().getAllCableTiles() != null){
        	int energyPerTick = tile.getNetwork().getAllProducerDrain();
        	boolean canAddMore;
        	
        	if(energyPerTick > 3000){
        		canAddMore = true;
        	}else{
        		canAddMore = false;
        	}
        	
        	this.fontRendererObj.drawString("Cables: "+tile.getNetwork().getAllCableTiles().size(), x + 80, y + 100, 0x990000, false);
        	this.fontRendererObj.drawString("Energy in Network: "+ energyPerTick,x+80, y+110, 0x990000, false);
        	if(canAddMore){
            	this.fontRendererObj.drawString("May be Able to add more: "+ canAddMore,x + 80, y+120, 0x00FF00, false);
        		}else{
                	this.fontRendererObj.drawString("May be Able to add more: "+ canAddMore,x+80,y+ 120, 0x990000, false);

        		}
        	}
      
        }
    
      
}