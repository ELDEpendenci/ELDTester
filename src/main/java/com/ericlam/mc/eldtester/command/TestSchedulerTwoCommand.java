package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eld.services.ScheduleService;
import com.ericlam.mc.eldtester.ELDTester;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "two",
        description = "two scheduler"
)
public class TestSchedulerTwoCommand implements CommandNode {


    @Inject
    private ScheduleService service;

    @Override
    public void execute(CommandSender commandSender) {
        commandSender.sendMessage("starting scheduler");
        service.callAsync(() -> {
            commandSender.sendMessage("sleep 5 seconds in async");
            Thread.sleep(5000);
            return "abc";
        }, ELDTester.getProvidingPlugin(ELDTester.class)).thenRunSync(result -> {
            commandSender.sendMessage("get the result "+result+" in sync!");
            commandSender.sendMessage("sending number 123");
            return 123;
        }).thenRunAsync(re -> {
            commandSender.sendMessage("received "+re+" in async!");
            commandSender.sendMessage("add 123 into "+re+" with 5 secs");
            Thread.sleep(5000);
            return re + 123;
        }).thenRunSync(res -> {
            commandSender.sendMessage("received "+res+" in sync!");
            commandSender.sendMessage("the final result is "+res);
            return null;
        }).join();
    }
}
