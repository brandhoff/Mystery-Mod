package com.CiD.MysteryMod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockLift extends BlockBase{

	public BlockLift(Class BlockTile, String BlockName) {
		super(Material.glass, 1.0F, BlockTile, BlockName);

	}

	
	@Override
	public boolean onBlockActivated(World world, int x,
			int y, int z, EntityPlayer player,
			int side, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {

		if(side == 1){
			if(!world.isRemote){
				if(player.isSneaking()){

					for(int i = 1; i<40; i++){
						if(world.getBlock(x, y-i, z) != null){
							Block b = world.getBlock(x, y-i, z);
								if(b instanceof BlockLift){
									if(world.getBlock(x, (y-i)+2, z) == Blocks.air&&world.getBlock(x, (y-i)+1, z) == Blocks.air){
							            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / ( 0.4F + 0.8F));

									player.setPositionAndUpdate(x+0.5, (y-i)+1, z+0.5);
						            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / ( 0.4F + 0.8F));

									break;
								}
									}
						}
					}
				}
				else{
					for(int i = 1; i<40; i++){
						if(world.getBlock(x, y+i, z) != null){
							Block b = world.getBlock(x, y+i, z);
								if(b instanceof BlockLift){
									if(world.getBlock(x, (y+i)+2, z) == Blocks.air&&world.getBlock(x, (y+i)+1, z) == Blocks.air){
							            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / ( 0.4F + 0.8F));

									player.setPositionAndUpdate(x+0.5, (y+i)+1, z+0.5);
						            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / ( 0.4F + 0.8F));

									break;
								}
									}
						}
					}
				}
				
				
				
			}
		}
		
		
		return true;
	}
}
