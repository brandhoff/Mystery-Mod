package com.CiD.MysteryMod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.GUI.Book.GUImystBook;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerBender;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerEnergy;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerMachine;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerMachineBase;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.Container.ContainerPressureFurnace;
import com.CiD.MysteryMod.TecEvolution.GUI.GUIMachineInventory;
import com.CiD.MysteryMod.TecEvolution.GUI.GUIbaseEnergyTile;
import com.CiD.MysteryMod.TecEvolution.GUI.GUIbaseMachine;
import com.CiD.MysteryMod.TecEvolution.GUI.GUIbender;
import com.CiD.MysteryMod.TecEvolution.GUI.GUIcablePanel;
import com.CiD.MysteryMod.TecEvolution.GUI.GUInuclearReactor;
import com.CiD.MysteryMod.TecEvolution.GUI.GUIpressureFurnace;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileBaseInventoryMachine;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityBender;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMachine;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityNuclearReactor;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityPressureFurnace;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler {
	  private Minecraft mc;
public static final int MYSTBOOK_GUI_ID = 0;
public static final int NUCLEAR_REACTOR_GUI_ID = 1;
public static final int CABLE_PANEL_GUI_ID = 2;
public static final int MACHINE_BASE_GUI_ID = 3;
public static final int ENERGY_TILE_GUI_ID = 4;
public static final int MACHINE_INVENTORY_GUI_ID = 5;
public static final int BENDER_GUI_ID = 6;
public static final int PRESSURE_FURNACE_GUI_ID = 7;


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
case MACHINE_BASE_GUI_ID: return new ContainerMachine(player.inventory, (TileEntityMachine) tile);
case ENERGY_TILE_GUI_ID: return new ContainerEnergy(player.inventory, (TileEntityEnergy) tile);
case MACHINE_INVENTORY_GUI_ID: return new ContainerMachineBase(player.inventory, (TileBaseInventoryMachine) tile);
case BENDER_GUI_ID: return new ContainerBender(player.inventory, (TileEntityBender) tile);
case PRESSURE_FURNACE_GUI_ID: return new ContainerPressureFurnace(player.inventory, (TileEntityPressureFurnace) tile);

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
case MACHINE_BASE_GUI_ID: return new GUIbaseMachine(player.inventory, (TileEntityMachine) tile);
case ENERGY_TILE_GUI_ID: return new GUIbaseEnergyTile(player.inventory, (TileEntityEnergy) tile);
case MACHINE_INVENTORY_GUI_ID: return new GUIMachineInventory(player.inventory, (TileBaseInventoryMachine) tile);
case BENDER_GUI_ID: return new GUIbender(player.inventory, (TileEntityBender) tile);
case PRESSURE_FURNACE_GUI_ID: return new GUIpressureFurnace(player.inventory, (TileEntityPressureFurnace) tile);

default:
return null;

			}
		}
	
}
