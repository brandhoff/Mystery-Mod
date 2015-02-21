package com.CiD.MysteryMod.TecEvolution.Entity.Projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class DroidBullet extends EntityThrowable{
EntityLivingBase target;
boolean onCooldown = false;
int cooldown = 20;
	public DroidBullet(World world, double x, double y, double z, EntityLivingBase target, EntityLiving user) {
		super(world, user);
//		super(world);
		this.target = target;
//		this.motionY = 0.2;
	}

	public DroidBullet(World world) {
		super(world);
		
	}
	
		@Override
		public void writeEntityToNBT(NBTTagCompound p_70014_1_) {

			super.writeEntityToNBT(p_70014_1_);
		}
	
		@Override
		public void readFromNBT(NBTTagCompound p_70020_1_) {

			super.readFromNBT(p_70020_1_);
		}
		
		@Override
			public void onEntityUpdate() {

				super.onEntityUpdate();
				if(target != null){
					if(!onCooldown){
					setThrowableHeading(target.posX, target.posY, target.posZ, 1, 1);
					}else{
						cooldown--;
						if(cooldown == 0){
							onCooldown = false;
							cooldown = 20;
						}
					}
				}
				
				
			}
	
	@Override
	protected void onImpact(MovingObjectPosition Mpos) {

		if(Mpos.entityHit == null){
			worldObj.createExplosion(this, Mpos.blockX, Mpos.blockY, Mpos.blockZ, 1, true);
		}
		if(Mpos.entityHit != null){
			worldObj.createExplosion(this, Mpos.entityHit.posX, Mpos.entityHit.posY, Mpos.entityHit.posZ, 1, true);
		}
	}

}
