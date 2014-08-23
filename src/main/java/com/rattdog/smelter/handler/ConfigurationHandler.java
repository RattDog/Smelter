package com.rattdog.smelter.handler;


import com.rattdog.smelter.reference.Reference;
import com.rattdog.smelter.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import sun.rmi.log.LogHandler;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean configvalue = false;

    public static void init(File configfile)
    {
        if (configuration == null) {
            // create the Configuration object from the given config file
            configuration = new Configuration(configfile);
        }


        LogHelper.info("ConfigValue = " + configvalue);

    }



    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfiguration();
        }
    }

    public void loadConfiguration() {
           // load in the configuration file
           // configuration.load();

            // process the configuration settings
            configvalue = configuration.get(Configuration.CATEGORY_GENERAL,"ConfigValue",true,"This is the config value").getBoolean();

            // save the configuration file if changes
            if (configuration.hasChanged()) {
                configuration.save();
            }


    }

}
