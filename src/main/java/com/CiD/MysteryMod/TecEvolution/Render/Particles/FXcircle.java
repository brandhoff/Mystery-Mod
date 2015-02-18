package com.CiD.MysteryMod.TecEvolution.Render.Particles;

import com.CiD.MysteryMod.Blocks.BlockBase;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class FXcircle extends EntityFX
{
   
	
	
	
	float smokeParticleScale;
	private double radius;
    public FXcircle(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float rot2, float green2, float blue)
    {
        this(par1World, par2, par4, par6, par8, par10, par12, 1.0F, 0, 0, 1);
    }

    public FXcircle(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float rot2, float green2, float blue,double Radius )
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
       
        this.smokeParticleScale = this.particleScale;

        this.setRBGColorF(rot2, green2, blue);
        this.particleScale = 0.5F;
        this.particleMaxAge = 20*2;
        this.noClip = true;
        this.preventEntitySpawning = false;
        this.radius = Radius;
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
    	 par1Tessellator.setBrightness(getBrightnessForRender(1));
        this.particleScale = this.smokeParticleScale;
        super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
        this.isBurning();


        setParticleIcon(BlockBase.IconParticleSimple);

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
    public int getFXLayer() {
    	
    	return 1;
    }

    
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

       double r = this.radius;
       double speed = 0.5;
	this.motionX =  r * Math.sin(this.ticksExisted * speed) - r * Math.sin((this.ticksExisted + 1)* speed);
	this.motionY = 0.001F;
			this.motionZ =  r * Math.cos(this.ticksExisted * speed) - r * Math.cos((this.ticksExisted + 1)* speed);
	this.ticksExisted++;
    this.moveEntity(this.motionX, this.motionY, this.motionZ);

    }
}
