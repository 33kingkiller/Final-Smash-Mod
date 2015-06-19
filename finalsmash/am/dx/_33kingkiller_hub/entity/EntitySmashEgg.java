package am.dx._33kingkiller_hub.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import am.dx._33kingkiller_hub.entity.passive.EntitySmashCube;
import am.dx._33kingkiller_hub.main.Smash;

public class EntitySmashEgg extends EntityThrowable {

	public EntitySmashEgg(World worldIn) {
		super(worldIn);
	}
	
	public EntitySmashEgg(World worldIn, EntityLivingBase p_i1780_2_) {
        super(worldIn, p_i1780_2_);
    }

    public EntitySmashEgg(World worldIn, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
        super(worldIn, p_i1781_2_, p_i1781_4_, p_i1781_6_);
    }

	@Override
	protected void entityInit() {

	}

	@Override
	protected void onImpact(MovingObjectPosition p_70184_1_) {
		if (p_70184_1_.entityHit != null) {
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isRemote) {
            byte b0 = 1;

            if (this.rand.nextInt(32) == 0) {
                b0 = 4;
            }

            for (int i = 0; i < b0; ++i) {
                EntitySmashCube entitySmash = new EntitySmashCube(this.worldObj);
                entitySmash.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entitySmash);
            }
        }

        for (int j = 0; j < 8; ++j) {
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, new int[] {Item.getIdFromItem(Smash.eggSmashCube)});
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

}
