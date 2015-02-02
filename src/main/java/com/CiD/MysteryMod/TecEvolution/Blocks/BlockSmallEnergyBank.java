package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;

public class BlockSmallEnergyBank extends BlockBase{

	public BlockSmallEnergyBank(Material material, Float hardness,
			 String BlockName) {
		super(material, hardness, TileEntityEnergy.class, BlockName);

	
	}
//0 == down
//1 == up
//2 == MZ
//3 == Z
//4 == MX
//5 == X	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float p_149727_7_,
			float p_149727_8_, float p_149727_9_) {
		TileEntityEnergy tl = (TileEntityEnergy) world.getTileEntity(x, y, z);
		if(!world.isRemote){
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.tec_wrench){
			if( player.isSneaking()){
			switch(side){
			case 0: tl.setSideOutput(TecHelper.SIDE_DOWN, true);
			case 1: tl.setSideOutput(TecHelper.SIDE_UP, true);
			case 2: tl.setSideOutput(TecHelper.SIDE_MZ, true);
			case 3: tl.setSideOutput(TecHelper.SIDE_Z, true);
			case 4: tl.setSideOutput(TecHelper.SIDE_X, true);
			case 5: tl.setSideOutput(TecHelper.SIDE_MX, true);

					}
				}else{
				//TODO ADD CHAT MESSAGE
				player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"Energy: "+tl.getMomEnergy()));
				}
			}
		}
		
		
		
		return true;
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityEnergy tl = new TileEntityEnergy();
		tl.ini(1000000, 100);
		return tl;
	}
}

