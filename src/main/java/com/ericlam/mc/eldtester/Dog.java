package com.ericlam.mc.eldtester;

import org.bukkit.plugin.Plugin;


public class Dog implements Animal {

    @Override
    public void speak(Plugin plugin) {
        plugin.getLogger().info("Dog: woof!");
    }

}
