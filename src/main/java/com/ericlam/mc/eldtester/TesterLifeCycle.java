package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDLifeCycle;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import java.util.Map;

public class TesterLifeCycle implements ELDLifeCycle {


    @Inject
    private Map<String, Plugin> plugins;

    @Override
    public void onEnable(JavaPlugin javaPlugin) {
        javaPlugin.getLogger().info(plugins.toString());
    }

    @Override
    public void onDisable(JavaPlugin javaPlugin) {

    }
}
