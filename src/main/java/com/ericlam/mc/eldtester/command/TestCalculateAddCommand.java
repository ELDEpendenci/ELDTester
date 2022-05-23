package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import org.bukkit.command.CommandSender;

@Commander(
        name = "add",
        description = "calculate add command",
        alias = {"ad", "plus", "a"}
)
public class TestCalculateAddCommand implements CommandNode {

    @CommandArg(order = 0)
    private int one;

    @CommandArg(order = 1, optional = true)
    private int two = 0;

    @Override
    public void execute(CommandSender commandSender) {
        commandSender.sendMessage(one+" + "+two+" = "+(one + two));
    }
}
