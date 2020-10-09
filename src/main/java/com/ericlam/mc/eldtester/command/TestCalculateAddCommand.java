package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.annotations.RemainArgs;
import com.ericlam.mc.eld.components.CommandNode;
import org.bukkit.command.CommandSender;

import java.util.List;

@Commander(
        name = "add",
        description = "calculate add command",
        alias = {"ad", "plus", "a"}
)
public class TestCalculateAddCommand implements CommandNode {

    @CommandArg(order = 0)
    private int one;

    @CommandArg(order = 1)
    private int two;

    @RemainArgs
    private List<String> args;

    @Override
    public void execute(CommandSender commandSender) {
        commandSender.sendMessage(one+" + "+two+" = "+(one + two));
        commandSender.sendMessage("remainArgs: "+args.toString());
    }
}
