package com.CiD.MysteryMod;

import com.CiD.MysteryMod.GUI.Book.GUImystBook;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.GUI.GUIcablePanel;
import com.CiD.MysteryMod.TecEvolution.GUI.GUInuclearReactor;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityNuclearReactor;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler {
	  private Minecraft mc;
public static final int MYSTBOOK_GUI_ID = 0;
public static final int NUCLEAR_REACTOR_GUI_ID = 1;
public static final int CABLE_PANEL_GUI_ID = 2;

public GUIHandler() {
NetworkRegistry.INSTANCE.registerGuiHandler(MysteryMain.instance, this);
}

@Override
public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
TileEntity tile = world.getTileEntity(x, y, z);

switch(id) {
case MYSTBOOK_GUI_ID: return null;
case NUCLEAR_REACTOR_GUI_ID: return new ContainerNuclearReactor(player.inventory, (TileEntityNuclearReactor) tile);
case CABLE_PANEL_GUI_ID: return null;

default:
return null;
}

}












@Override
public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
TileEntity tile = world.getTileEntity(x, y, z);

switch(id) {
case MYSTBOOK_GUI_ID: return id == 0 ? new GUImystBook(player, player.getCurrentEquippedItem()) : null;
case NUCLEAR_REACTOR_GUI_ID: return new GUInuclearReactor(player.inventory, (TileEntityNuclearReactor) tile);
case CABLE_PANEL_GUI_ID: return new GUIcablePanel(tile);

default:
return null;

			}
		}
	
}
