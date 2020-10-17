package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.components.ELDListener;
import com.ericlam.mc.eld.components.EventListeners;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TestELDListener implements ELDListener {

    @Override
    public void defineNodes(EventListeners eventListeners) {
        eventListeners.listen(PlayerJoinEvent.class)
                .expireAfter(3)
                .filter(e -> e.getPlayer().hasPermission("player.join.silent"))
                .handle(e -> e.setJoinMessage(null));

        eventListeners.listen(AsyncPlayerChatEvent.class)
                .priority(EventPriority.MONITOR)
                .filter(e -> !e.isCancelled())
                .filter(e -> e.getPlayer().hasPermission("player.chat"))
                .fork()
                .ifTrue(e -> e.getPlayer().sendMessage("you have player.chat permission"))
                .ifFalse(e -> e.getPlayer().sendMessage("you don't have player.chat permission"));

        eventListeners.listen(PlayerQuitEvent.class)
                .filter(e -> e.getPlayer().hasPermission("vip.permission"))
                .fork()
                .ifTrue(this::onPlayerQuitIsVIP)
                .ifFalse(this::onPlayerQuitIsNotVIP);
    }

    public void onPlayerQuitIsVIP(PlayerQuitEvent event) {
        event.setQuitMessage("vip left the server: " + event.getPlayer().getName());
    }


    public void onPlayerQuitIsNotVIP(PlayerQuitEvent event) {
        event.setQuitMessage("player left the server: " + event.getPlayer().getName());
    }
}
