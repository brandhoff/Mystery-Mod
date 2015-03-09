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

public class ItemInkScanner extends BaseItem{

	public ItemInkScanner(String name) {
		super("used to copy all the colors ", name);
		setMaxStackSize(1);
//		setFull3D();
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
		
		if(scannerStack.stackTagCompound != null && scannerStack.stackTagCompound.hasKey("red")){
			toolTip.add(EnumChatFormatting.RED+"RED: "+ scannerStack.stackTagCompound.getFloat("red"));
			toolTip.add(EnumChatFormatting.GREEN+"GREEN: "+scannerStack.stackTagCompound.getFloat("green"));
			toolTip.add(EnumChatFormatting.BLUE+"BLUE: "+scannerStack.stackTagCompound.getFloat("blue"));
		}
		
		
	  
	  }

}
