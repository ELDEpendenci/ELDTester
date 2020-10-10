package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eldtester.TestConfig;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "reload",
        description = "config reload command"
)
public class TestConfigReloadCommand implements CommandNode {

    @Inject
    private TestConfig config;

    @Override
    public void execute(CommandSender commandSender) {
        config.getController().reload();
        commandSender.sendMessage("reload completed");
    }
}
