package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eldtester.MyService;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "bye",
        description = "bye command"
)
public class TestServiceByeCommand implements CommandNode {


    @Inject
    private MyService myService;

    @Override
    public void execute(CommandSender commandSender) {
        myService.sayGoodBye(commandSender);
    }
}
