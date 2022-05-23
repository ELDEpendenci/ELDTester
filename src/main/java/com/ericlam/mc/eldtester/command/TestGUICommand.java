package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eldgui.InventoryService;
import com.ericlam.mc.eldgui.UIDispatcher;
import com.ericlam.mc.eldgui.UINotFoundException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

@Commander(
        name = "gui",
        description = "gui command",
        playerOnly = true
)
public class TestGUICommand implements CommandNode {

    @Inject
    private InventoryService inventoryService;

    @Override
    public void execute(CommandSender sender) {
        var player = (Player) sender;
        try {
            UIDispatcher dispatcher = inventoryService.getUIDispatcher("main");
            dispatcher.openFor(player);
        } catch (UINotFoundException e) {
            player.sendMessage("UI not found.");
        }
    }

}
