package com.CiD.MysteryMod.TecEvolution.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.vecmath.Vector3d;

import com.CiD.MysteryMod.TecEvolution.TecDATA;
import com.CiD.MysteryMod.TecEvolution.Entity.Projectile.DroidBullet;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySecurityDroid extends EntityLiving implements IChangeColor{
private EntityPlayer owner; //SAVED AS STRING
private String ownerName;
private List<EntityPlayer> whiteList = new ArrayList<EntityPlayer>();
private double movePosY;
private double movePosX;
private double movePosZ;
private static Vec3 staticVector = Vec3.createVectorHelper(0.0D, 0.0D, 0.0D);
private boolean inCoolDown = true;
private int CoolDown = TecDATA.DROID_COOLDWON;
	public EntitySecurityDroid(World world, EntityPlayer owner) {
		super(world);
		this.owner = owner;
		ownerName = owner.getDisplayName();
		whiteList.add(owner);

	}
	public EntitySecurityDroid(World world) {
		super(world);
	}
	 
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);

            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);

    }

	@Override
	public void onUpdate() {
		super.onUpdate();
	if(!inCoolDown){
		List<EntityLivingBase> entities = worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(30.0D, 30.0D, 30.0D));		
		Random ran = new Random();
		if(entities != null && !entities.isEmpty()){
			for(int i = 0; i < entities.size(); i++){
				if(entities.get(i) != owner && !(entities.get(i) instanceof EntitySecurityDroid)){
					if(!whiteList.contains(entities.get(i)) && entities.get(i) instanceof EntityLivingBase){
						if(!worldObj.isRemote){
							worldObj.spawnEntityInWorld(new DroidBullet(worldObj, posX, posY, posZ, entities.get(i)));
							inCoolDown = true;
						}
					}
				}
			}
		}
	}else{
		CoolDown--;
		if(CoolDown == 0){
			inCoolDown = false;
			CoolDown = TecDATA.DROID_COOLDWON;
		}
	}
}	
	@Override
		protected boolean isAIEnabled() {
			return false;
		}
	
	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(18, new Float(1));
        this.dataWatcher.addObject(19, new Byte((byte)0));
        this.dataWatcher.addObject(20, new Byte((byte)BlockColored.func_150032_b(1)));
        super.entityInit();
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		owner = worldObj.getPlayerEntityByName(tag.getString("owner"));
		ownerName = tag.getString("owner");
		
		
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		tag.setString("owner", owner.getDisplayName());
		
		
	}

	@Override
	public float getRed() {

		return 1.0F;
	}

	@Override
	public float getGreen() {

		return 0;
	}

	@Override
	public float getBlue() {

		return 0;
	}

}
