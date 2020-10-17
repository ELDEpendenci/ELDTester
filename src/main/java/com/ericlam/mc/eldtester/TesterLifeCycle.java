package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDLifeCycle;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import java.util.Set;

public class TesterLifeCycle implements ELDLifeCycle {

    @Inject
    private Set<LogService> logServices;

    @Override
    public void onEnable(JavaPlugin javaPlugin) {
        logServices.forEach(l -> l.log(javaPlugin.getLogger()));
    }

    @Override
    public void onDisable(JavaPlugin javaPlugin) {

    }
}
