package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import org.bukkit.command.CommandSender;

@Commander(
        name = "calculate",
        description = "test calculate command",
        alias = {"cal", "c"}
)
public class TestCalculateCommand implements CommandNode {

    @Override
    public void execute(CommandSender commandSender) {
    }
}
