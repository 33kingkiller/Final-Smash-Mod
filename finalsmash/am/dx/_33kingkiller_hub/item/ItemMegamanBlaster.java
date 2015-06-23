package am.dx._33kingkiller_hub.item;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import am.dx._33kingkiller_hub.entity.EntityBlast;
import am.dx._33kingkiller_hub.main.Smash;

public class ItemMegamanBlaster extends ItemBow {
	
		//Constructor.
		public ItemMegamanBlaster() {
			this.setCreativeTab(Smash.tabSmash);
			this.maxStackSize = 1;
	        this.setMaxDamage(384);
		}
			
		//Creates an arrow after the bow is shot (and other things).
		@Override
		public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft) {		        int j = this.getMaxItemUseDuration(stack) - timeLeft;
			net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(playerIn, stack, j);
		    if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
	        j = event.charge;

		    boolean flag = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

		    if (flag || playerIn.inventory.hasItem(Items.arrow) || !playerIn.inventory.hasItem(Items.arrow)) {
		    	float f = (float)j / 20.0F;
		    	f = (f * f + f * 2.0F) / 3.0F;

		    	if ((double)f < 0.1D) {
		    		return;
		    	}

		    	if (f > 1.0F) {
		    		f = 1.0F;
		    	}

		    	EntityBlast entityarrow = new EntityBlast(worldIn, playerIn, f * 2.0F);
		    	EntityBlast entityarrow1 = new EntityBlast(worldIn, playerIn, f * 2.0F);
		    	EntityBlast entityarrow2 = new EntityBlast(worldIn, playerIn, f * 2.0F);
		    	EntityBlast entityarrow3 = new EntityBlast(worldIn, playerIn, f * 2.0F);
		    	EntityBlast entityarrow4 = new EntityBlast(worldIn, playerIn, f * 2.0F);
		            
		    	if (f == 1.0F) {
		    		entityarrow.setIsCritical(true);
		    		entityarrow1.setIsCritical(true);
		    		entityarrow2.setIsCritical(true);
		    		entityarrow3.setIsCritical(true);
		    		entityarrow4.setIsCritical(true);
		    	}

		    	int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

		    	if (k > 0) {
		    		entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
		    		entityarrow1.setDamage(entityarrow1.getDamage() + (double)k * 0.5D + 0.5D);
                	entityarrow2.setDamage(entityarrow2.getDamage() + (double)k * 0.5D + 0.5D);
                	entityarrow3.setDamage(entityarrow3.getDamage() + (double)k * 0.5D + 0.5D);
                	entityarrow4.setDamage(entityarrow4.getDamage() + (double)k * 0.5D + 0.5D);
		    	}

		    	int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

		    	if (l > 0) {
		    		entityarrow.setKnockbackStrength(l);
		    		entityarrow1.setKnockbackStrength(l);
		    		entityarrow2.setKnockbackStrength(l);
		    		entityarrow3.setKnockbackStrength(l);
		    		entityarrow4.setKnockbackStrength(l);
		    	}

		    	stack.damageItem(1, playerIn);
		    	worldIn.playSoundAtEntity(playerIn, "finalsmash:blaster.shoot", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

		    	if (flag) {
		    		entityarrow.canBePickedUp = 2;
		    		entityarrow1.canBePickedUp = 2;
		    		entityarrow2.canBePickedUp = 2;
		    		entityarrow3.canBePickedUp = 2;
		    		entityarrow4.canBePickedUp = 2;
		    	}else {
		    		playerIn.inventory.addItemStackToInventory(new ItemStack(Items.arrow, 0));
		    	}

		    	playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

		    	if (!worldIn.isRemote) {
		    		worldIn.spawnEntityInWorld(entityarrow);
		    		worldIn.spawnEntityInWorld(entityarrow1);
		    		worldIn.spawnEntityInWorld(entityarrow2);
		    		worldIn.spawnEntityInWorld(entityarrow3);
		    		worldIn.spawnEntityInWorld(entityarrow4);
		    	}
		            
		    	if(playerIn.inventory.hasItem(Smash.megamanBlaster) && !playerIn.capabilities.isCreativeMode) {
		    		playerIn.inventory.consumeInventoryItem(Smash.megamanBlaster);
		    	}
		    }
		}
			
		//Happens when the player right-clicks while holding the bow.
		@Override
		public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
			net.minecraftforge.event.entity.player.ArrowNockEvent event = new net.minecraftforge.event.entity.player.ArrowNockEvent(playerIn, itemStackIn);
			if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return event.result;
			
			if (playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(Items.arrow) || !playerIn.inventory.hasItem(Items.arrow)) {
		            playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
			}
		        
			return itemStackIn;
		}
			
		//Gets the models/textures for the bow.
		@Override
		public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining) {
			ModelResourceLocation modelresourcelocation = new ModelResourceLocation(Smash.MODID + ":FinalSmashitem.megamanBlaster", "inventory");
			
			if(stack.getItem() == this && player.getItemInUse() != null) {
				if(useRemaining >= 18) {
					modelresourcelocation = new ModelResourceLocation(Smash.MODID + ":FinalSmashitem.megamanBlaster_pulling_2", "inventory");
				}
				else if(useRemaining > 13) {
					modelresourcelocation = new ModelResourceLocation(Smash.MODID + ":FinalSmashitem.megamanBlaster_pulling_1", "inventory");
				}
				else if(useRemaining > 0) {
					modelresourcelocation = new ModelResourceLocation(Smash.MODID + ":FinalSmashitem.megamanBlaster_pulling_0", "inventory");
				}
			}
		        
			return modelresourcelocation;
		}

}
