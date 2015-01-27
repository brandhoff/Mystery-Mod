package com.CiD.MysteryMod;

import com.CiD.MysteryMod.GUI.Book.GUImystBook;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler {
	  private Minecraft mc;
public static final int MYSTBOOK_GUI_ID = 0;
public GUIHandler() {
NetworkRegistry.INSTANCE.registerGuiHandler(MysteryMain.instance, this);
}

@Override
public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
TileEntity entity = world.getTileEntity(x, y, z);

switch(id) {
case MYSTBOOK_GUI_ID:
return null;

default:
return null;
}

}












@Override
public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
TileEntity entity = world.getTileEntity(x, y, z);

switch(id) {
case MYSTBOOK_GUI_ID:
	return id == 0 ? new GUImystBook(player, player.getCurrentEquippedItem()) : null;


default:
return null;

			}
		}
	
}
