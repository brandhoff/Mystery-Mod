package com.CiD.MysteryMod.TecEvolution.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Items.BaseItem;
import com.CiD.MysteryMod.TecEvolution.Entity.EntitySecurityDroid;

public class ItemDroid extends BaseItem{

	public ItemDroid(String tooltip, String name) {
		super(tooltip, name);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player != null && !world.isRemote){
			EntitySecurityDroid droid = new EntitySecurityDroid(world, player);
			droid.setPosition(player.posX, player.posY, player.posZ);
			world.spawnEntityInWorld(droid);
			return new ItemStack(stack.getItem(), stack.stackSize--);

		}
		return stack;
	}
	
}
