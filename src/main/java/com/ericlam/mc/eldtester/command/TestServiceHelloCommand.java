package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eldtester.MyService;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "hello",
        description = "hello command"
)
public class TestServiceHelloCommand implements CommandNode {

    @Inject
    private MyService myService;

    @Override
    public void execute(CommandSender commandSender) {
        myService.sayHelloTo(commandSender);
    }
}
