package com.CiD.MysteryMod.TecEvolution.Render.Events;

import java.util.Random;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityAtomicMiner;

public class RenderMinerBox{
	private double boundBox = 30;
    public RenderMinerBox(){}

	
	public void render(TileEntity tile, double x, double y, double z, float p_147500_8_) {
		if(tile instanceof TileEntityAtomicMiner){
			TileEntityAtomicMiner miner = (TileEntityAtomicMiner) tile;
			if(((TileEntityAtomicMiner) tile).shouldRenderBox()){
				Random ran = new Random();
					for(int i = 0; i < 30; i++){
					GL11.glTranslated(x +0.5, y -i, z+0.5);
					  GL11.glDisable(GL11.GL_LIGHTING);

					  GL11.glBegin(GL11.GL_LINES);
					    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);  
				        GL11.glColor4f(0.0f,0.0F,1.0f,1.0F);          
				        
				        GL11.glVertex3d( boundBox, boundBox,-boundBox);          // Top Right Of The Quad (Top)
				        GL11.glVertex3d(-boundBox, boundBox,-boundBox);          // Top Left Of The Quad (Top)
				        GL11.glVertex3d(-boundBox, boundBox, boundBox);          // Bottom Left Of The Quad (Top)
				        GL11.glVertex3d( boundBox, boundBox, boundBox);          // Bottom Right Of The Quad (Top)

				        GL11.glVertex3d( boundBox,-boundBox, boundBox);          // Top Right Of The Quad (Bottom)
				        GL11.glVertex3d(-boundBox,-boundBox, boundBox);          // Top Left Of The Quad (Bottom)
				        GL11.glVertex3d(-boundBox,-boundBox,-boundBox);          // Bottom Left Of The Quad (Bottom)
				        GL11.glVertex3d( boundBox,-boundBox,-boundBox);          // Bottom Right Of The Quad (Bottom)

				        GL11.glVertex3d( boundBox, boundBox, boundBox);          // Top Right Of The Quad (Front)
				        GL11.glVertex3d(-boundBox, boundBox, boundBox);          // Top Left Of The Quad (Front)
				        GL11.glVertex3d(-boundBox,-boundBox, boundBox);          // Bottom Left Of The Quad (Front)
				        GL11.glVertex3d( boundBox,-boundBox, boundBox);          // Bottom Right Of The Quad (Front)

				        GL11.glVertex3d( boundBox,-boundBox,-boundBox);          // Bottom Left Of The Quad (Back)
				        GL11.glVertex3d(-boundBox,-boundBox,-boundBox);          // Bottom Right Of The Quad (Back)
				        GL11.glVertex3d(-boundBox, boundBox,-boundBox);          // Top Right Of The Quad (Back)
				        GL11.glVertex3d( boundBox, boundBox,-boundBox);          // Top Left Of The Quad (Back)

				        GL11.glVertex3d(-boundBox, boundBox, boundBox);          // Top Right Of The Quad (Left)
				        GL11.glVertex3d(-boundBox, boundBox,-boundBox);          // Top Left Of The Quad (Left)
				        GL11.glVertex3d(-boundBox,-boundBox,-boundBox);          // Bottom Left Of The Quad (Left)
				        GL11.glVertex3d(-boundBox,-boundBox, boundBox);          // Bottom Right Of The Quad (Left)

				        GL11.glVertex3d( boundBox, boundBox,-boundBox);          // Top Right Of The Quad (Right)
				        GL11.glVertex3d( boundBox, boundBox, boundBox);          // Top Left Of The Quad (Right)
				        GL11.glVertex3d( boundBox,-boundBox, boundBox);          // Bottom Left Of The Quad (Right)
				        GL11.glVertex3d( boundBox,-boundBox,-boundBox);          // Bottom Right Of The Quad (Right)
				        GL11.glEnd();
						  GL11.glEnable(GL11.GL_LIGHTING);

						GL11.glTranslated(-(x +0.5), -(y - i),- (z+0.5));
					}
			}
		}
	}
    
}