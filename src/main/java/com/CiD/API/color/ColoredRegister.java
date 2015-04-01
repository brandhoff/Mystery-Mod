package com.CiD.API.color;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;

public class ColoredRegister {
public static List<Class<?extends TileEntity>> tileList = new ArrayList<Class<? extends TileEntity>>();

	public static void registerTileEntity(Class<?extends TileEntity> TileEntityClass){
      if(TileEntityClass.isAnnotationPresent(ColoredTile.class))
		tileList.add(TileEntityClass);
	}
	
	
}
