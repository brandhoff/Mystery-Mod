package com.CiD.MysteryMod.GUI;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public abstract class BaseGUI extends GuiContainer{
	private boolean showInfoContex = false;

	public BaseGUI(Container p_i1072_1_) {
		super(p_i1072_1_);

	}
	
	@Override
	public void initGui() {
		super.initGui();
	    buttonList.add(new GuiButton(1, 20, 42, 90, 20, "Show Help"));

	}
	
	@Override		
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		if(showInfoContex){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(new ResourceLocation(MysteryMain.MODID+":textures/gui/infoGUI.png"));
        int l = (width - xSize) / 3;
         int i1 = (height - ySize) / 3;
         drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
     }
	
	}
	@Override
	public void drawScreen(int par1, int par2, float p_73863_3_) {
	

	  super.drawScreen(par1, par2, p_73863_3_);
	
	}

	@Override		
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		  
	
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button) {
		super.actionPerformed(button);
		
		switch(button.id){
		case 1:{
				if(showInfoContex){
					showInfoContex = false;
				}else{
					showInfoContex = true;

				}
		
			}
		}
	}
	
}
