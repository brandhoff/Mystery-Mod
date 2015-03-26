package com.CiD.MysteryMod.TecEvolution.KaonLinked;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import com.CiD.MysteryMod.Helper.Exception.CListException;

public class TileEntityKaonLinkedStorage extends TileEntity{
private List<UUID> players = new ArrayList<UUID>();
private List<String> msgs = new ArrayList<String>();

	public TileEntityKaonLinkedStorage() {

	}
	
	/** USED TO SET A DISPLAY MSG **/
	public void addInformationTextfromPlayer(UUID id, String text, int listID){
		if(id != null){
			if(players.contains(id)){
				msgs.set(listID, text);
			}else{
				players.add(id);
			}
		}
	}
	
	
	public void addToPlayerList(UUID e, int listID) throws CListException{
		if(e != null){
			if(!players.contains(e)){
				 if(players.get(listID) == null){
					 players.set(listID, e);
				 }else{
//					 throw new CListException("tryed to add a player at an already given id");
				 }
			}
		}else{
			throw new NullPointerException("Tryed to add a Player with the value null to the players list int the kaon linked");
		}
	}
	
	/** gets the specific ListID for the given Player **/
	public int getPlayerListID(EntityPlayer player){
		UUID id = player.getUniqueID();
		if(players.contains(id)){
			int x;
			for(int i = 0; i < players.size(); i++){
				if(players.get(i) == id){
					x = i;
					return x; 
				}
			}
		}else{
			return 666;
		}
		return 666;
		
	}
}
