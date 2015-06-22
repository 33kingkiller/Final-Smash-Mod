package am.dx._33kingkiller_hub.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemMarthSword extends ItemSword {

	public ItemMarthSword(ToolMaterial material) {
		super(material);
	}
	
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
		par3EntityLiving.worldObj.playSoundAtEntity(par3EntityLiving, "finalsmash:homerun", 1, 1);
		par1ItemStack.damageItem(2, par3EntityLiving);
        return true;
    }
   

}
