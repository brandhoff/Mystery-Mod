package com.CiD.MysteryMod.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.CiD.MysteryMod.MysteryMain;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseItem extends Item
{
	private String Itemtooltip;
	public BaseItem(String tooltip){

		super();
	Itemtooltip = tooltip;
	this.maxStackSize = 64;
	this.setCreativeTab(MysteryMain.item_tab);
	this.setTextureName(this.getUnlocalizedName().substring(5));
	GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		// TODO Auto-generated method stub
		return super.onItemRightClick(stack, world, player);
	}


@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister)
{
	this.itemIcon = iconRegister.registerIcon(MysteryMain.MODID+":" + this.getUnlocalizedName().substring(5));
	}

@Override
@SideOnly(Side.CLIENT)
public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
  {
	if(Itemtooltip != null){
		par3List.add(EnumChatFormatting.AQUA+"Hold 'TAB' for more Information");
		if(Keyboard.isKeyDown(Keyboard.KEY_TAB)){
        par3List.add(EnumChatFormatting.GREEN+Itemtooltip); 
		}
	}
  }

}