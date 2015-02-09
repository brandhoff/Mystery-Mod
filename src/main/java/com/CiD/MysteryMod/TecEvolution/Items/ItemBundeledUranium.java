package com.CiD.MysteryMod.TecEvolution.Items;

import scala.xml.persistent.SetStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Items.BaseItem;

public class ItemBundeledUranium extends BaseItem{

	public ItemBundeledUranium(String tooltip, String name) {
		super("Warning this is highly radiaktive", name);

		this.setMaxStackSize(1);
	}

	
	@Override
	public void onUpdate(ItemStack stack, World world,
			Entity entity, int p_77663_4_, boolean p_77663_5_) {
		super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);
		if(entity instanceof EntityPlayer){
			if(!world.isRemote){
				EntityPlayer player = (EntityPlayer) entity;
				player.addPotionEffect(new PotionEffect(Potion.poison.id, 1, 1));
			}
		}
	}
	
	
}
