package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.Network.PacketDispatcher;
import com.CiD.MysteryMod.Network.packet.client.RenderMinerBoxPacket;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityAtomicMiner;


public class BlockAtomicMiner extends BlockMachineBase{

	public BlockAtomicMiner(String BlockName) {
		super(Material.iron, 1.0F, TileEntityAtomicMiner.class, BlockName);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
		EntityPlayer player, int metadata, float what, float these,
		float are) {
		if(player.isSneaking()){
			TileEntityAtomicMiner miner = (TileEntityAtomicMiner) world.getTileEntity(x, y, z);
			if(miner.shouldRenderBox()){
				miner.shouldRenderBox(false);
			}else{
				
				miner.shouldRenderBox(true);
			}
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these,
			are);
}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityAtomicMiner tl = new TileEntityAtomicMiner();
		tl.ini(1, 1);
		return tl;
			}
	@Override
	public void breakBlock(World world, int x, int y,
			int z, Block p_149749_5_, int p_149749_6_) {

	
		TileEntityAtomicMiner pipe = (TileEntityAtomicMiner) world.getTileEntity(x, y, z);
		ItemStack stack = pipe.getStackInSlot(0);
		ItemStack stack2 = pipe.getStackInSlot(1);

		if(!world.isRemote && stack != null){
			world.spawnEntityInWorld(new EntityItem(world, x, y, z,stack));
		}if(!world.isRemote && stack2 != null){
			world.spawnEntityInWorld(new EntityItem(world, x, y, z,stack2));
		}
		super.breakBlock(world, x, y, z,
				p_149749_5_, p_149749_6_);
	}
}
