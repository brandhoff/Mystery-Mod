package com.CiD.MysteryMod.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Events.ActiveEvent;
import com.CiD.MysteryMod.Events.BaseEvent;
import com.CiD.MysteryMod.Pages.PageInfo;
import com.CiD.MysteryMod.Player.ExtendedPlayer;
import com.CiD.MysteryMod.TileEntity.TileEntityGreenCrystal;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGreenCrystal extends BlockBase{

	public BlockGreenCrystal(Material material, Float hardness,
			Class BlockTile, String BlockName) {
		super(material, hardness, BlockTile, BlockName);
		setBlockBounds(0.25F, 0F, 0.25F, 0.75F, 1.6F, 0.75F);
	}

	@Override
	public boolean isOpaqueCube() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int p_149727_6_, float p_149727_7_,
			float p_149727_8_, float p_149727_9_) {
		if(player != null){
		TileEntityGreenCrystal tile = (TileEntityGreenCrystal) world.getTileEntity(x, y, z);
		if(!tile.isActive()){
		if(player.getHeldItem() != null){
		if(player.getHeldItem().getItem() == Items.diamond){
			player.getHeldItem().stackSize = player.getHeldItem().stackSize - 1;
			tile.setActive(true);
			BaseEvent.startPlayerGreenCrystalEvent(player, tile);
			if(!world.isRemote){
				ExtendedPlayer exPlayer = ExtendedPlayer.get(player);
				exPlayer.setKnowsPage(PageInfo.PAGE1_sword, true);
			}
			return true;
			}
		}
	}
		
		
		
}
		return false;
	}
	@Override
	public void onBlockHarvested(World world, int x,
			int y, int z, int p_149681_5_,
			EntityPlayer player) {
		TileEntityGreenCrystal tile = (TileEntityGreenCrystal) world.getTileEntity(x, y, z);
		if(tile.isActive())
		tile.setActive(false);
		if(tile.getWorldObj().isRemote)
		Minecraft.getMinecraft().getSoundHandler().stopSounds();

		super.onBlockHarvested(world, x, y, z,p_149681_5_, player);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_,
			int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return false;
	}
	
	
	// FROM THE DOOR CLASS
	
	   /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        this.setBlockBoundsBasedOnState(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
        return super.getSelectedBoundingBoxFromPool(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
    }

    
    
    
    
}
