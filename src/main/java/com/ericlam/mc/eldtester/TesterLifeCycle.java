package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDLifeCycle;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;

public class TesterLifeCycle implements ELDLifeCycle {

    private final TesterSingleton singleton;

    @Inject
    public TesterLifeCycle(TesterSingleton singleton){
        this.singleton = singleton;
        singleton.setKey("start", "started a insertion in constructor");
    }

    @Inject
    private TestConfig config;

    @Override
    public void onEnable(JavaPlugin javaPlugin) {
        singleton.setKey("abc", "fuck");
        singleton.setKey("xyz", "diu");
        javaPlugin.getLogger().info(singleton.getString());
        javaPlugin.getLogger().info(config.toString());
    }

    @Override
    public void onDisable(JavaPlugin javaPlugin) {
        javaPlugin.getLogger().info(singleton.getString());
        javaPlugin.getLogger().info(config.toString());
    }
}
