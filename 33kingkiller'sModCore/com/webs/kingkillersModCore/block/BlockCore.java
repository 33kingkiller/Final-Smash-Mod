package com.webs.kingkillersModCore.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockCore {
	
	//BROKEN
	public static void DefineBlockVariable(Block par1, Material par2, String par3, CreativeTabs par4) {
		par1 = new BlockBase(par2).setUnlocalizedName(par3).setCreativeTab(par4);
	}
	
	//BROKEN
	public static void DefineBlockOreVariable(Block par1, String par2, CreativeTabs par3) {
		par1 = new BlockOre().setUnlocalizedName(par2).setCreativeTab(par3);
	}
	
	//WORKING
	public static void GenerateOverworld(World par1, Random par2, int par3, int par4, IBlockState par5, int par6, int par7) {
		for(int i = 0; i < par7; i++) {
			int XC = par3 + par2.nextInt(16);
			int YC = par2.nextInt(256);
			int ZC = par4 + par2.nextInt(16);
			BlockPos pos = new BlockPos(XC, YC, ZC);
			new WorldGenMinable(par5, par6).generate(par1, par2, pos);
		}
	}

}
