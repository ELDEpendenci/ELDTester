package com.ericlam.mc.eldtester;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.server.ServerLoadEvent;

import javax.inject.Inject;

public class TestListeners implements Listener {

    @Inject
    private TestConfig config;

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (e.getMessage().equals("config")) {
            e.getPlayer().sendMessage(config.toString());
        }
    }

    @EventHandler
    public void onServerLoad(ServerLoadEvent e){
        Bukkit.getLogger().info("server loaded: "+e.getType());
    }


}
