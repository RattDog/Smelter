package com.rattdog.smelter;

import com.rattdog.smelter.handler.ConfigurationHandler;
import com.rattdog.smelter.proxy.IProxy;
import com.rattdog.smelter.reference.Reference;
import com.rattdog.smelter.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import sun.rmi.log.LogHandler;

/**
 * Created by David on 8/21/2014.
 */

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class Smelter {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.Instance(Reference.MOD_ID)
    public static Smelter instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        LogHelper.info("Pre Initialization event");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
        LogHelper.info("Initialization event");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post Initialization event");

    }

}

