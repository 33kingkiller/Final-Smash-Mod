package am.dx._33kingkiller_hub.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import am.dx._33kingkiller_hub.entity.EntitySmashEgg;
import am.dx._33kingkiller_hub.main.Smash;

public class ItemSmashEgg extends Item {
	
	public ItemSmashEgg()
    {
        this.maxStackSize = 16;
        this.setCreativeTab(Smash.tabSmash);
    }
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }

        worldIn.playSoundAtEntity(playerIn, "finalsmash:smashcubeHit", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(new EntitySmashEgg(worldIn, playerIn));
        }
        
        return itemStackIn;
    }
}
