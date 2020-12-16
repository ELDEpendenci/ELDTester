package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eldtester.ELDTester;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "log",
        description = "log command in console"
)
public class TestLogCommand implements CommandNode {

    @Inject
    private ELDTester plugin;

    @CommandArg(order = 0, identifier = "message")
    private String msg;

    @Override
    public void execute(CommandSender commandSender) {
        plugin.getLogger().info(msg);
        commandSender.sendMessage("message logged in console.");
    }
}
