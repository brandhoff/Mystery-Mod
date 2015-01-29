package com.CiD.MysteryMod.CodeAble.Commands;

import com.CiD.MysteryMod.CodeAble.ICodeAble;

import net.minecraft.world.World;

public class CCommandBreakblock extends CCommand{

	public CCommandBreakblock(String[] args, World world) {
		super(args, world);
	}

	
	@Override
	public void Run() {
		int x = Integer.parseInt(this.arguments[0]);
		int y = Integer.parseInt(this.arguments[1]);
		int z = Integer.parseInt(this.arguments[2]);

		world.func_147480_a(x, y, z, false);

	}
	
	
}
