package com.CiD.MysteryMod.TecEvolution.Render.Particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.CiD.MysteryMod.Blocks.BlockBase;
import com.CiD.MysteryMod.TecEvolution.TecEvolutionMain;

public class FXsimple extends EntityFX {

	public FXsimple(World world, double x, double y, double z, double motionX, double motionY, double motionZ, float rot, float green, float blue) {
		super(world, x, y, z, motionX, motionY, motionZ);	
		
		this.setParticleIcon(BlockBase.IconParticleSimple);
		noClip = true;
		particleScale = 3;
		particleAlpha = rand.nextFloat();
		particleRed = rot;
		particleGreen = green;
		particleBlue = blue;
		particleMaxAge = 200;
	}
	
	
	
	public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
    	 par1Tessellator.setBrightness(getBrightnessForRender(1));
        super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
        this.isBurning();



    }
    public int getBrightnessForRender(float par1)
    {
        float f1 = 15.0F;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        if (f1 > 1.0F)
        {
            f1 = 1.0F;
        }

        int i = super.getBrightnessForRender(par1);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f1 * 15.0F * 16.0F);

        if (j > 240)
        {
            j = 240;
        }

        return j | k << 16;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        float f1 = 15.0F;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        if (f1 > 1.0F)
        {
            f1 = 1.0F;
        }

        float f2 = super.getBrightness(15.0F);
        return f2 * f1 + (1.0F + f1);
    }
	
	
	
	
	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

       double r = 2.5;
       double speed = 7.05;
	this.ticksExisted++;
    this.moveEntity(this.motionX, this.motionY, this.motionZ);
		particleScale = (1 - (float)particleAge / particleMaxAge) * 3;
	}
	
	@Override
	public int getFXLayer() {
		return 1;
	}
	
}
