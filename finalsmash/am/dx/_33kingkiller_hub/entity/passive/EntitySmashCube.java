package am.dx._33kingkiller_hub.entity.passive;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import am.dx._33kingkiller_hub.main.Smash;

public class EntitySmashCube extends EntityAmbientCreature {

	//Constructor. Registers misc.
	public EntitySmashCube(World worldIn) {
		super(worldIn);
		this.isImmuneToFire = true;
        this.experienceValue = 5;
		this.setSize(0.5F, 0.9F);
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
        return "finalsmash:mob.smashcube.hurt";
    }
	
	//Getter for the sound made when the entity reaches 0 HP (in this case also the setter).
	@Override
	protected String getDeathSound() {
        return "finalsmash:mob.smashcube.death";
    }
	@Override
	protected Item getDropItem() {
        return Smash.itemSmashBall;
    }

	//Sets the base attributes for the entity.
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.1D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
    }

}
