package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import org.bukkit.command.CommandSender;

@Commander(
        name = "service",
        description = "service command"
)
public class TestServiceCommand implements CommandNode {


    @Override
    public void execute(CommandSender commandSender) {
    }


}
