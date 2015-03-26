package com.CiD.MysteryMod.TecEvolution.KaonLinked;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;

public class BlockKaonLinked extends BlockBase{

	public BlockKaonLinked(Material material, Float hardness,String BlockName) {
		super(material, hardness, null, BlockName);

	}

	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {

		if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityKaonLinkedStorage){
			TileEntityKaonLinkedStorage tile = (TileEntityKaonLinkedStorage) world.getTileEntity(x, y, z);
			
			if(player.isSneaking()){
				return false;
			}else{
				if(player.getCurrentEquippedItem() == null){
					tile.addToPlayerList(player.getUniqueID());
				}
			}
		}
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileEntityKaonLinkedStorage tile = KaonLinkedMain.KAON_TILE;
		return tile;
	}
}
