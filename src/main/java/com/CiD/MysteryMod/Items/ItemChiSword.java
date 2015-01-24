package com.CiD.MysteryMod.Items;

import com.CiD.MysteryMod.Mobs.EntityChiGuard;
import com.CiD.MysteryMod.Pages.PageInfo;
import com.CiD.MysteryMod.Player.ExtendedPlayer;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChiSword extends BaseItem{

	public ItemChiSword() {
		super("");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

		if(!world.isRemote){
			ExtendedPlayer exPlayer = ExtendedPlayer.get(player);
			if(exPlayer.knowsPage(PageInfo.PAGE1_sword)){
				if(exPlayer.consumeChi(300)){
				
						world.spawnEntityInWorld(new EntityChiGuard(world, player));
						world.spawnEntityInWorld(new EntityChiGuard(world, player));
						world.spawnEntityInWorld(new EntityChiGuard(world, player));
						world.spawnEntityInWorld(new EntityChiGuard(world, player));

					
				}
			}else{
			}
		}
		
		
		return stack;
	}
	
}
