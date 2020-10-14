package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import org.bukkit.command.CommandSender;

@Commander(
        name = "minus",
        description = "minus command",
        alias = {"reduce", "m"}
)
public class TestCalculateMinusCommand implements CommandNode {

    @CommandArg(order = 0, labels = {"first value"})
    private int one;

    @CommandArg(order = 1, labels = {"second value"}, optional = true)
    private int two = 55;

    @Override
    public void execute(CommandSender commandSender) {
        commandSender.sendMessage(one+" - "+two+" = "+(one - two));
    }
}
