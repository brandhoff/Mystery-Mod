package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.CableNetwork.CableNetwork;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCablePanel;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCablePanel extends BlockBase{

	public BlockCablePanel(Material material, Float hardness,
			 String BlockName) {
		super(material, hardness, TileEntityCablePanel.class, BlockName);
		setLightOpacity(0);

		setLightLevel(0.1F);
		setBlockBounds(0.3F, 0.3F, 0.3F, 0.7F, 0.7F, 0.7F);
	
	}
//0 == down
//1 == up
//2 == MZ
//3 == Z
//4 == MX
//5 == X	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int metadata, float what, float these, float are) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            }
    player.openGui(MysteryMain.instance, GUIHandler.CABLE_PANEL_GUI_ID, world, x, y, z);
            return true;
    }
	@Override
	public boolean isOpaqueCube() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isNormalCube() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void onBlockAdded(World world, int x,
			int y, int z) {
		world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
		world.markBlockForUpdate(x, y, z);
		world.markBlockForUpdate(x+1, y, z);
		world.markBlockForUpdate(x-1, y, z);
		world.markBlockForUpdate(x, y, z+1);
		world.markBlockForUpdate(x, y, z-1);
		world.markBlockForUpdate(x, y+1, z);
		world.markBlockForUpdate(x, y-1, z);

		super.onBlockAdded(world, x, y, z);
	}
	
	@Override
	public void breakBlock(World world, int x, int y,
			int z, Block p_149749_5_, int p_149749_6_) {

		TileEntityCablePanel tl = (TileEntityCablePanel) world.getTileEntity(x, y, z);
		tl.onRemove();
//		tl.getNetwork().removeNetwork();
		super.breakBlock(world, x, y, z,
				p_149749_5_, p_149749_6_);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int xi) {
		TileEntityCablePanel tile = new TileEntityCablePanel();
		CableNetwork nt = new CableNetwork(tile);
		tile.setNetwork(nt);
		boolean[] connections = TecHelper.checkConnections(world, tile.xCoord, tile.yCoord, tile.zCoord);
		World worldObj = tile.getWorldObj();
		int xCoord = tile.xCoord;
		int yCoord = tile.yCoord;
		int zCoord = tile.zCoord;
		for(int i = 0; i < connections.length; i++){
			if(connections[i]){
				switch(i){
				case TecHelper.SIDE_DOWN :{
				TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord -1 , zCoord);
					if(tl != null && tl instanceof TileEntityCable){
						TileEntityCable cable = (TileEntityCable)tl;
						if(cable.getNetwork() == null && nt != null){
							cable.setNetwork(nt);
							nt.addCable(cable);
							world.markBlockForUpdate(xCoord, yCoord, zCoord);
						}
					}
				
				}
				case TecHelper.SIDE_UP : {
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
					if(tl != null && tl instanceof TileEntityCable){
						TileEntityCable cable = (TileEntityCable)tl;
						if(cable.getNetwork() == null && nt != null){
							cable.setNetwork(nt);
							nt.addCable(cable);
							world.markBlockForUpdate(xCoord, yCoord, zCoord);

						}
					}

				}
				case TecHelper.SIDE_X : {
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
					if(tl != null && tl instanceof TileEntityCable){
						TileEntityCable cable = (TileEntityCable)tl;
						if(cable.getNetwork() == null && nt != null){
							cable.setNetwork(nt);
							nt.addCable(cable);
							world.markBlockForUpdate(xCoord, yCoord, zCoord);

						}
					}

				}
				case TecHelper.SIDE_MX : {
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
					if(tl != null && tl instanceof TileEntityCable){
						TileEntityCable cable = (TileEntityCable)tl;
						if(cable.getNetwork() == null && nt != null){
							cable.setNetwork(nt);
							nt.addCable(cable);
							world.markBlockForUpdate(xCoord, yCoord, zCoord);

						}
					}

				}
				case TecHelper.SIDE_Z : {
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
					if(tl != null && tl instanceof TileEntityCable){
						TileEntityCable cable = (TileEntityCable)tl;
						if(cable.getNetwork() == null && nt != null){
							cable.setNetwork(nt);
							nt.addCable(cable);
							world.markBlockForUpdate(xCoord, yCoord, zCoord);

						}
					}

				}
				case TecHelper.SIDE_MZ : {
					TileEntityEnergy tl = (TileEntityEnergy) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
					if(tl != null && tl instanceof TileEntityCable){
						TileEntityCable cable = (TileEntityCable)tl;
						if(cable.getNetwork() == null && nt != null){
							cable.setNetwork(nt);
							nt.addCable(cable);
							world.markBlockForUpdate(xCoord, yCoord, zCoord);

						}
					}

				}
			
			}
		}
}
		return tile;
	}
}
