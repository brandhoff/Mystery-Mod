package com.CiD.MysteryMod.TecEvolution.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CiD.MysteryMod.GUIHandler;
import com.CiD.MysteryMod.MysteryMain;
import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileBaseInventoryMachine;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityMachine;
import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityNuclearReactor;

public class BlockMachineInventoryBase extends BlockBase{

	public BlockMachineInventoryBase(String BlockName) {
		super(Material.iron, 5.0F, null, BlockName);

	}
	
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int metadata, float what, float these, float are) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            }
    player.openGui(MysteryMain.instance, GUIHandler.MACHINE_INVENTORY_GUI_ID, world, x, y, z);
            return true;
    }

	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		TileBaseInventoryMachine tl = new TileBaseInventoryMachine();
		tl.ini(1, 1);
		
		return tl;
		
		
	}
}
