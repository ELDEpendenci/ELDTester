package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eldtester.MyService;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;
import java.util.Map;

@Commander(
        name = "bye",
        description = "bye command"
)
public class TestServiceByeCommand implements CommandNode {


    @Inject
    private Map<String, MyService> myService;

    @CommandArg(order = 0)
    private boolean b = false;

    @Override
    public void execute(CommandSender commandSender) {
        myService.get(b ? "B" : "A").sayGoodBye(commandSender);
    }
}
