package com.CiD.MysteryMod.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BlockSwiftStone extends BlockBase{

	public BlockSwiftStone(Material material, Float hardness, Class BlockTile,
			String BlockName) {
		super(material, hardness, BlockTile, BlockName);
	}
	
	@Override
	public void onEntityWalking(World world, int x,
			int y, int z, Entity entity) {
		if(!world.isRemote){
			if(entity != null){
				if(entity instanceof EntityPlayer){
					EntityPlayer player = (EntityPlayer) entity;
					player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 5, 5)));				}
			}
		}
		
	}
	

}
