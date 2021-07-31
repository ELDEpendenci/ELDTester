package com.ericlam.mc.eldtester;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.PlayerInventory;

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


    /*
    @EventHandler
    public void inventoryDragEvent(InventoryDragEvent e){
        Player player = (Player) e.getWhoClicked();
        player.sendMessage("============ InventoryDragEvent ==============");
        player.sendMessage("drag type: "+e.getType());
        player.sendMessage("inventory slots: "+e.getInventorySlots());
        player.sendMessage("raw slots: "+e.getRawSlots());
        player.sendMessage("get old cursor: "+e.getOldCursor().getType());
        player.sendMessage("get cursor: "+(e.getCursor() == null ? "null" : e.getCursor().getType()));
        player.sendMessage("new items: "+e.getNewItems());
        player.sendMessage("is player inventory: "+(e.getInventory() instanceof PlayerInventory));
        player.sendMessage("===============================================");
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        player.sendMessage("============ InventoryClickEvent ==============");
        player.sendMessage("is player inventory: "+(e.getInventory() instanceof PlayerInventory));
        player.sendMessage("clicked slot: "+e.getSlot());
        player.sendMessage("clicked raw slot: "+e.getRawSlot());
        player.sendMessage("result: "+e.getRawSlot());
        player.sendMessage("get cursor: "+(e.getCursor() == null ? "null" : e.getCursor().getType()));
        player.sendMessage("horbar button"+e.getHotbarButton());
        player.sendMessage("===============================================");
    }

     */


}
