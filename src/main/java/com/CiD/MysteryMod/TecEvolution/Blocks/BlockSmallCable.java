package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCable;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSmallCable extends BlockBase{

	public BlockSmallCable(Material material, Float hardness,
			 String BlockName) {
		super(material, hardness, TileEntityCable.class, BlockName);
		setLightOpacity(0);

		setLightLevel(0.1F);
		setBlockBounds(0.3F, 0.3F, 0.3F, 0.7F, 0.7F, 0.7F);
	
	}
	
	@Override
	public void breakBlock(World world, int x, int y,
			int z, Block p_149749_5_, int p_149749_6_) {
		
		TileEntityCable cable = (TileEntityCable) world.getTileEntity(x, y, z);
		if(cable.getNetwork() != null)
		cable.getNetwork().removeCable(cable);
		super.breakBlock(world, x, y, z, p_149749_5_, p_149749_6_);

		
	}
	
//0 == down
//1 == up
//2 == MZ
//3 == Z
//4 == MX
//5 == X	

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
	public TileEntity createNewTileEntity(World world, int intager) {
		TileEntityCable thiscable = new TileEntityCable();
//		boolean[] connections = TecHelper.checkConnections(world, thiscable.xCoord, thiscable.yCoord, thiscable.zCoord);
//		for(int i = 0; i < connections.length; i++){
//			if(connections[i]){
//				switch(i){
//				case TecHelper.SIDE_DOWN :{
//				TileEntityEnergy tl = (TileEntityEnergy) world.getTileEntity(thiscable.xCoord, thiscable.yCoord -1 , thiscable.zCoord);
//				
//				if(tl != null){
//
//				boolean[] output = tl.getAllOutputSides();	
//				if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_UP]) return true;
//				
//					}
//				}
//				case TecHelper.SIDE_UP : {
//					TileEntityEnergy tl = (TileEntityEnergy) world.getTileEntity(thiscable.xCoord, thiscable.yCoord+1, thiscable.zCoord);
//					
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null ){ 
//						if(tl instanceof TileEntityStorage){ 
//
//							if(output[TecHelper.SIDE_DOWN]){
//
//						return true;
//					
//					}
//					}}
//				}}
//				case TecHelper.SIDE_X : {
//					TileEntityEnergy tl = (TileEntityEnergy) world.getTileEntity(thiscable.xCoord+1, thiscable.yCoord, thiscable.zCoord);
//					
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MX]) return true;
//					}
//				}
//				case TecHelper.SIDE_MX : {
//					TileEntityEnergy tl = (TileEntityEnergy) world.getTileEntity(thiscable.xCoord-1, thiscable.yCoord, thiscable.zCoord);
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_X]) return true;
//					}
//				}
//				case TecHelper.SIDE_Z : {
//					TileEntityEnergy tl = (TileEntityEnergy) world.getTileEntity(xCoord, yCoord, zCoord+1);
//					if(tl != null){
//
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_MZ]) return true;
//					}
//				}
//				case TecHelper.SIDE_MZ : {
//					TileEntityEnergy tl = (TileEntityEnergy) world.getTileEntity(xCoord, yCoord, zCoord-1);
//					
//					if(tl != null){
//
//					boolean[] output = tl.getAllOutputSides();	
//
//					if(tl != null && tl instanceof TileEntityStorage && output[TecHelper.SIDE_Z]) return true;
//					}
//				}
//			
//			}
//		}
//}
		
		return thiscable;
	}
}

