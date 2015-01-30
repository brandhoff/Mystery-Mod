package com.CiD.MysteryMod.CodeAble;

import net.minecraft.world.World;

import com.CiD.MysteryMod.CodeAble.Commands.CCommandBreakblock;

public class CScriptCommands {

	public static void TryRunCommand(String commandName, String[] args, World world) throws CommandNotFoundException{

		if(commandName != null){
			if(commandName.equalsIgnoreCase("BreakBlock")){
				CCommandBreakblock c = new CCommandBreakblock(args, world);
				c.Run();
			}
		}
				
	}

	
}
