package com.CiD.MysteryMod.Items;

import com.CiD.MysteryMod.CodeAble.CScriptToJava;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDebug extends BaseItem{

	public ItemDebug(String tooltip, String name) {
		super(tooltip, name);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		String[] code =
				{"BreakBlock(12 366 9086)",
				"BreakBlock(123 423 12)",
				"BreakBlock(432 341 95)"};
			CScriptToJava compiler = new CScriptToJava(code);
			String[] args0 = compiler.getArguments(0);
			System.err.println("Line 0 Args: "+ args0[0]+" " + args0[1]+" " + args0[2]);
			System.err.println("Line 1 Args: "+ compiler.getArguments(1));
			System.err.println("Line 2 Args: "+ compiler.getArguments(2));

		return super.onItemRightClick(stack, world, player);
	}
	
	
}
