package am.dx._33kingkiller_hub.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import am.dx._33kingkiller_hub.main.Smash;

public class EntitySmashCube extends EntityAnimal {

	//Constructor. Registers AI and other properties.
	public EntitySmashCube(World worldIn) {
		super(worldIn);
		this.isImmuneToFire = true;
        this.experienceValue = 5;
		this.setSize(0.9F, 1.9F);
		this.setCustomNameTag("SETTLE IT IN SMASH!");
		this.tasks.addTask(0, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(2, new EntityAITempt(this, 1.25D, Smash.eggSmashCube, false));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
	}
	
	//Getter for sound volume (in this case also the setter).
	@Override
	protected float getSoundVolume() {
        return 0.1F;
    }
	
	//Getter for sound pitch (in this case also the setter).
	@Override
	protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }
	
	//Getter for the sound made when the entity takes damage (in this case also the setter).
	@Override
	protected String getHurtSound() {
        return "finalsmash:smashcubeHit";
    }
	
	//Getter for the sound made when the entity reaches 0 HP (in this case also the setter).
	@Override
	protected String getDeathSound() {
        return "finalsmash:smashcubeDeath";
    }
	
	//Getter for entity drops (in this case also the setter).
	@Override
	protected void dropFewItems(boolean b, int i) {
		int randomDrop = this.rand.nextInt(6);
		if (randomDrop == 1) {
			this.dropItem(Smash.marthSword, 1);
		}else if(randomDrop == 2) {
			this.dropItem(Smash.zeldaBow, 1);
		}else if(randomDrop == 3) {
			this.dropItem(Smash.linkSword, 1);
		}else if(randomDrop == 4) {
			this.dropItem(Smash.pitBow, 1);
		}else if(randomDrop == 5) {
			this.dropItem(Smash.megamanBlaster, 1);
		}else {
			this.dropItem(Items.diamond, 1);
		}
	}

	//Sets the base attributes for the entity.
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.9D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

	//Code for breeding.
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntitySmashCube(worldObj);
	}

}
