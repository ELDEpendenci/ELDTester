package com.ericlam.mc.eldtester;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

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
    public void onPlayerChat2(AsyncPlayerChatEvent e) {
        e.getPlayer().sendMessage("hi");
    }

    @EventHandler
    public void onPlayerChat3(AsyncPlayerChatEvent e) {
        e.getPlayer().sendMessage("hi2");
    }

    @EventHandler
    public void onPlayerChat4(AsyncPlayerChatEvent e) {
        e.getPlayer().sendMessage("hi3");
    }


}
