package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.services.ScheduleService;
import com.ericlam.mc.eldtester.ELDTester;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;
import java.util.List;

@Commander(
        name = "four",
        description = "test scheduler four"
)
public class TestSchedulerFourCommand implements CommandNode {

    @Inject
    private ScheduleService scheduleService;
    @Inject
    private ELDTester plugin;

    @CommandArg(order = 1, labels = "<with order>", optional = true)
    private boolean order = true;

    @Override
    public void execute(CommandSender commandSender) {
        var one = scheduleService.runAsync(plugin, () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            commandSender.sendMessage("one!");
        });

        var two = scheduleService.runAsync(plugin, () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            commandSender.sendMessage("two!");
        });

        var three = scheduleService.runAsync(plugin, () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            commandSender.sendMessage("three!");
        });

        if (order){
            commandSender.sendMessage("with order..");
            scheduleService.runAsync(plugin, () -> {
                try {
                    one.block();
                    two.block();
                    three.block();
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    commandSender.sendMessage("done!");
                }

            }).join();
        }else{
            commandSender.sendMessage("without order..");
            scheduleService.runAllAsync(plugin, List.of(one, two, three)).join();
        }
    }
}
