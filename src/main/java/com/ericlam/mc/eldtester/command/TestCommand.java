package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import org.bukkit.command.CommandSender;

@Commander(
        name = "test",
        description = "test command",
        alias = {"tes", "te"}
)
public class TestCommand implements CommandNode {

    @Override
    public void execute(CommandSender commandSender) {
    }

}
