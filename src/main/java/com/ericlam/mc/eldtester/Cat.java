package com.ericlam.mc.eldtester;

import org.bukkit.plugin.Plugin;


public class Cat implements Animal {
    @Override
    public void speak(Plugin plugin) {
        plugin.getLogger().info("Cat: meow~");
    }
}
