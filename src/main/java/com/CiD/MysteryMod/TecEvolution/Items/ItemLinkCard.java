package com.CiD.MysteryMod.TecEvolution.Items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Items.BaseItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLinkCard extends BaseItem{

	public ItemLinkCard(String name) {
		super("used to link up Gravitomagnets", name);
		setMaxStackSize(1);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.isSneaking()){
			stack.stackTagCompound = null;
		}
		return super.onItemRightClick(stack, world, player);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack scannerStack, EntityPlayer player, List toolTip, boolean par4)
	  {
		
		if(scannerStack.stackTagCompound != null && scannerStack.stackTagCompound.hasKey("x")){
			toolTip.add(EnumChatFormatting.RED+"X: "+ scannerStack.stackTagCompound.getFloat("x"));
			toolTip.add(EnumChatFormatting.GREEN+"Y: "+scannerStack.stackTagCompound.getFloat("y"));
			toolTip.add(EnumChatFormatting.BLUE+"Z: "+scannerStack.stackTagCompound.getFloat("z"));
		}
		
		
	  
	  }

}
