package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eldtester.TestConfig;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "check",
        description = "config check command"
)
public class TestConfigCheckCommand implements CommandNode {

    @Inject
    private TestConfig config;

    @Override
    public void execute(CommandSender commandSender) {
        commandSender.sendMessage(config.toString());
    }
}
