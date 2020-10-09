package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

@Commander(
        name = "say",
        description = "test say command",
        alias = {"sa", "s"}
)
public class TestSayCommand implements CommandNode {

    @CommandArg(order = 0, identifier = "message")
    private String message;

    @Override
    public void execute(CommandSender commandSender) {
        Bukkit.broadcastMessage(commandSender.getName()+" says: "+message);
    }
}
