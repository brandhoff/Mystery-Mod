package com.CiD.MysteryMod.TecEvolution.GUI;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;

public class GUIcontainerInfo extends GuiScreen {
	 /** The X size of the inventory window in pixels. */
    protected int xSize = 255;
    /** The Y size of the inventory window in pixels. */
    protected int ySize = 240;

    public GUIcontainerInfo() {

		
		}

       
       
        @Override
        public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
        	
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/infoGUI.png"));
            int x = (width - xSize) /2;
            int y = (height - ySize)/2;
            this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        	
        }
      
}