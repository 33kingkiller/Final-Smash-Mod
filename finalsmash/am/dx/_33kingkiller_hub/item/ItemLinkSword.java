package am.dx._33kingkiller_hub.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemLinkSword extends ItemSword {

	public ItemLinkSword(ToolMaterial material) {
		super(material);
	}
	
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par3EntityLiving.worldObj.playSoundAtEntity(par3EntityLiving, "finalsmash:link", 1, 1);
		par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int n, boolean b) {
		if (itemStack.getItemDamage() >= itemStack.getMaxDamage()) {
			entity.worldObj.playSoundAtEntity(entity, "finalsmash:homerun", 1, 1);
			itemStack.damageItem(2, (EntityLivingBase) entity);
		}
	}

}
