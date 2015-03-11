package com.CiD.MysteryMod.GUI;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.TecEvolution.GUI.IhasInfoGui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public abstract class BaseGUI extends GuiContainer implements IhasInfoGui{
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
		super.drawGuiContainerForegroundLayer(par1, par2);
		
	
	}
	@Override
	public void drawScreen(int par1, int par2, float p_73863_3_) {
		 for (int k = 0; k < this.buttonList.size(); ++k)
         {
             GuiButton guibutton = (GuiButton)this.buttonList.get(k);
             guibutton.drawButton(this.mc, par1, par2);

         }	
		if(!showInfoContex){
			super.drawScreen(par1, par2, p_73863_3_);
		}else{
			drawGuiContainerBackgroundLayer(p_73863_3_, par1,par2);
		}
	
	}

	@Override		
	/** DONT USE THIS !! USE drawBackScreen*/
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
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
	     }else{
	    	 drawBackScreen(f,i,j);
	     }
	
	}
	
	public void drawBackScreen(float f, int i, int j){
		
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
