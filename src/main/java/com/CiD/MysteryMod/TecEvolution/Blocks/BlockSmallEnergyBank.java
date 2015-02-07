package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;
import com.CiD.MysteryMod.TecEvolution.TecHelper;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEnergyProducer;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityEnergy;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityStorage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//TODO CLIENT AND SEVER OUT OF SYN ON WORLD RELOAD WITH LEFT CLICK
public class BlockSmallEnergyBank extends BlockBase{
private IIcon OtherSides;
public static IIcon Connector;
	public BlockSmallEnergyBank(Material material, Float hardness,
			 String BlockName) {
		super(material, hardness, TileEntityStorage.class, BlockName);

	
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
		TileEntityEnergy tl = (TileEntityStorage) world.getTileEntity(x, y, z);
		if(!world.isRemote){
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.tec_wrench){

			switch(side){
//			case 0: tl.setSideOutput(TecHelper.SIDE_DOWN, true);
//			case 1: tl.setSideOutput(TecHelper.SIDE_UP, true);
			case 2:{ tl.setSideOutput(TecHelper.SIDE_MZ, true); break;}
			case 3:{ tl.setSideOutput(TecHelper.SIDE_Z, true); break;}
			case 4:{ tl.setSideOutput(TecHelper.SIDE_X, true); break;}
			case 5:{ tl.setSideOutput(TecHelper.SIDE_MX, true); break;}

					}
				}
			}
		
		
		
		world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
		world.markBlockForUpdate(x, y, z);
		return true;
	}
	
	@Override
	public void onBlockClicked(World world, int x,
			int y, int z, EntityPlayer player) {
		TileEntityStorage tl = (TileEntityStorage) world.getTileEntity(x, y, z);
		if(!world.isRemote){
			world.markBlockForUpdate(x, y, z);
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == TecEvolutionMain.tec_wrench){
			tl.printEnergy(player);
		}
			}
		}
		
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityStorage tl = new TileEntityStorage();
		tl.ini(1000000, 1000);
		return tl;
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
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		
		blockIcon = reg.registerIcon(MysteryMain.MODID + ":" + this.getUnlocalizedName().substring(5));
		OtherSides = reg.registerIcon(MysteryMain.MODID + ":white");
		Connector = reg.registerIcon(MysteryMain.MODID+":textures/blocks/output_connecter.png");
	}
	
	
	@Override
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if(side > 1){
				return this.blockIcon;
				}else{
					return this.OtherSides;
				}
		}
}

