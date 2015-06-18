package com.webs.kingkillersModCore.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = Init.MODID, version = Init.VERSION, name = Init.NAME)
public class Init {
	
	public static final String MODID = "kingkillersModCore";
	public static final String NAME = "33kingkiller's Mod Core";
    public static final String VERSION = "1.7.10";

    @EventHandler
    public void preinit(FMLPostInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		System.out.println("[" + System.nanoTime() + "] 33kingkiller's Mod Core Initialized.");
    }
}
