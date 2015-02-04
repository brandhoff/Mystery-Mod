package com.CiD.MysteryMod.TecEvolution.Render;

import java.util.Random;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.CiD.MysteryMod.client;
import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;

public class RenderCable extends TileEntitySpecialRenderer{
	private ModelCable model = new ModelCable();
	@Override
	public void renderTileEntityAt(TileEntity tile, double x,
			double y, double z, float p_147500_8_) {
		Random rand = new Random();
		TileEntityCable tl = (TileEntityCable) tile;
		GL11.glPushMatrix();
		GL11.glTranslated(x+0.21,y+0.21,z+0.21);
		if(!tl.isConnected())
		GL11.glRotated(tl.getRenderTick(), 1, 1, 1);
		
		 bindTexture(client.TEXTUREmodel_white);
	     model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		
		
		boolean connections[] = tl.//TecHelper.checkConnections(tl.getWorldObj(),(int) x, (int)y,(int) z);
 		for(int i = 0; i < connections.length; i++){
 			if(connections[i]){
 				switch(i){
 				case TecHelper.SIDE_DOWN:{
 					System.out.println("YEAH");
 					GL11.glPushMatrix();
 					GL11.glTranslated(x+0.21,y,z+0.21);
 										
 					 bindTexture(client.TEXTUREmodel_white);
 				     model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
 					GL11.glPopMatrix();
 				}

 				case TecHelper.SIDE_UP:{
 					
 				}

 				case TecHelper.SIDE_MX: ;
 				case TecHelper.SIDE_X: ;

 				case TecHelper.SIDE_MZ: ;
 				case TecHelper.SIDE_Z: ;

 				
 				}
 			}
 		}
		
	}

}
