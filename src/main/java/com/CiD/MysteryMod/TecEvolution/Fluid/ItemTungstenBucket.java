package com.CiD.MysteryMod.TecEvolution.Fluid;

import com.CiD.MysteryMod.MysteryMain;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBucket;

public class ItemTungstenBucket extends ItemBucket{

	public ItemTungstenBucket(Block fluid, String name) {
		super(fluid);
		GameRegistry.registerItem(this, name);

	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(MysteryMain.MODID+":" + this.getUnlocalizedName().substring(5));
		}

}
