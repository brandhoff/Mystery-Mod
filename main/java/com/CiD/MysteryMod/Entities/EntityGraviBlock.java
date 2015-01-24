package com.CiD.MysteryMod.Entities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Helper.Location;

public class EntityGraviBlock extends EntityFallingBlock{
private int flyTime;
private Location center;
private int centerX;
private int centerY;
private int centerZ;

	public EntityGraviBlock(World world, double x, double y, double z, Block block, Location centerLoc) {
		super(world, x, y, z, block);
		Random ran = new Random();

		centerX = centerLoc.getX();
		centerY = centerLoc.getY();
		centerZ = centerLoc.getZ();

		this.motionY = 1.2;
		//Small Vectors to center
//		this.motionX = 1/(centerX - this.posX);
//		this.motionZ = 1/(centerZ - this.posZ);
	}

//	@Override
//		public void onEntityUpdate() {
////			super.onEntityUpdate();
//			if(flyTime < 20*50){
//				doflyingLoop();
//			}else{
//				stopflyingLoop();
//			}
//			if(this.posY <= centerY){
//				this.setDead();
//			}
//		}

	@Override
		public void onUpdate() {
			super.onUpdate();
			if(flyTime < 20*10){
				doflyingLoop();
			}else{
				stopflyingLoop();
				if(this.posY <= centerY+2){
					this.setDead();
				}
			}
			
		}
	
	public void doflyingLoop(){
//		Random ran = new Random();
		this.motionY = 0.2;
		//Small Vectors to center
		if(centerX > posX){
			this.motionX = 1;
		}
		if(centerZ > posZ){
			this.motionZ = 1;
		}

		if(centerX < posX){
			this.motionX = 1;
		}
		if(centerZ < posZ){
			this.motionZ = 1;
		}
		flyTime++;
	}
	public void stopflyingLoop(){
		this.motionY = -0.51;
	
		flyTime++;
	}
	
	@Override
		public void writeToNBT(NBTTagCompound nbt) {
			super.writeToNBT(nbt);
			nbt.setInteger("flyTime", flyTime);
		}
	
	@Override
		public void readFromNBT(NBTTagCompound nbt) {
			super.readFromNBT(nbt);
			flyTime = nbt.getInteger("flyTime");
		}
	
}
