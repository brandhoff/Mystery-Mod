package com.CiD.MysteryMod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler {
	  private Minecraft mc;

public GUIHandler() {
NetworkRegistry.INSTANCE.registerGuiHandler(MysteryMain.instance, this);//instance().registerGuiHandler(Basis.instance, this);
}

@Override
public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
TileEntity entity = world.getTileEntity(x, y, z);

//switch(id) {
//case 0:
//return id == 0  ? new InventoryCsmelter(player.inventory, (TileCsmelter) entity) : null;
//case 1:
//return id == 0  ? new InventoryForcer(player.inventory, (TileForcer) entity) : null;
//default:
//return null;
//}

	return null;

}












@Override
public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
TileEntity entity = world.getTileEntity(x, y, z);

//switch(id) {
//case 0:
//	return id == 0 ? new GUIcSmelter(player.inventory, (TileCsmelter) entity) : null;
//case 1:
//	return id == 1 ? new GUIforcer(player.inventory, (TileForcer) entity) : null;
//
//default:
//return null;
//
//		}
//	}
return null;
	}
}
