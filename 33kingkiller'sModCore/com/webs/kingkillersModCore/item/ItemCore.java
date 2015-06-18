package com.webs.kingkillersModCore.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCore {
	
	//BROKEN
	public static void DefineItemVariable(Item par1, String par2, CreativeTabs par3) {
		par1 = new Item().setUnlocalizedName(par2).setCreativeTab(par3);
	}
	
	//BROKEN
	public static void DefineItemVariableSword(Item par1, ToolMaterial par2, String par3, CreativeTabs par4) {
		par1 = new ItemSword(par2).setUnlocalizedName(par3).setCreativeTab(par4);
	}
	
	//BROKEN
	public static void DefineItemVariableShovel(Item par1, ToolMaterial par2, String par3, CreativeTabs par4) {
		par1 = new ItemSpade(par2).setUnlocalizedName(par3).setCreativeTab(par4);
	}
	
	//BROKEN
	public static void DefineItemVariableHoe(Item par1, ToolMaterial par2, String par3, CreativeTabs par4) {
		par1 = new ItemHoe(par2).setUnlocalizedName(par3).setCreativeTab(par4);
	}
	
	//HALF-WORKING
	public static void RegisterItemVariable(Item par1, String par2) {
		GameRegistry.registerItem(par1, par2 + par1.getUnlocalizedName().substring(0));
	}
	
	//HALF-WORKING
	public static void AddSmeltingRecipe(Item par1, Item par2, float par3) {
		GameRegistry.addSmelting(par1, new ItemStack(par2), par3);
	}
	
	//HALF-WORKING
	public static void AddSmeltingRecipe(Item par1, Item par2, int par3, float par4) {
		GameRegistry.addSmelting(par1, new ItemStack(par2, par3), par4);
	}
	
	//WORKING
	public static void RegisterArmourMaterial(ArmorMaterial par1, String par2, String par3, int par4, int[] par5, int par6) {
		par1 = EnumHelper.addArmorMaterial(par2, par3, par4, par5, par6);
	}
	
	//TODO TEST
	public static void RegisterToolMaterial(ToolMaterial par1, String par2, int par3, int par4, float par5, float par6, int par7) {
		par1 = EnumHelper.addToolMaterial(par2, par3, par4, par5, par6, par7);
	}

}
