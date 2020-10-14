package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.components.ELDListener;
import com.ericlam.mc.eld.components.EventListeners;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestELDListener implements ELDListener {
    @Override
    public void defineNodes(EventListeners eventListeners) {
        eventListeners.listen(PlayerJoinEvent.class)
                .filter(e -> e.getPlayer().hasPermission("player.join.slient"))
                .handle(e -> e.setJoinMessage(null));

        eventListeners.listen(AsyncPlayerChatEvent.class)
                .priority(EventPriority.MONITOR)
                .filter(Cancellable::isCancelled)
                .filter(e -> e.getPlayer().hasPermission("player.chat"))
                .fork()
                .ifTrue(e -> e.getPlayer().sendMessage("you have player.chat permission"))
                .ifFalse(e -> e.getPlayer().sendMessage("you don't have player.chat permission"));
    }
}
