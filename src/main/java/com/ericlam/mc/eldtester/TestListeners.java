package com.ericlam.mc.eldtester;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import javax.inject.Inject;

public class TestListeners implements Listener {

    @Inject
    private MyService myService;


    @Inject
    private TestConfig config;


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        myService.sayHelloTo(e.getPlayer());
    }


    @EventHandler
    public void onPlayerQuit(PlayerSwapHandItemsEvent e){
        myService.sayGoodBye(e.getPlayer());
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if (e.getMessage().equals("config")){
            e.getPlayer().sendMessage(config.toString());
        }
    }




}
