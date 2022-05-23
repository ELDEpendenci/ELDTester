package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.services.ScheduleService;
import com.ericlam.mc.eldtester.ELDTester;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;
import java.text.MessageFormat;
import java.util.List;

@Commander(
        name = "three",
        description = "three scheduler"
)
public class TestSchedulerThreeCommand implements CommandNode {

    @Inject
    private ScheduleService scheduler;
    @Inject
    private ELDTester plugin;

    @Override
    public void execute(CommandSender commandSender) {

        ScheduleService.BukkitPromise<Object> mineA = scheduler.callAsync(plugin, () -> {
            commandSender.sendMessage("Mining A area, need 5 seconds...");
            Thread.sleep(5000);
            commandSender.sendMessage("A area mined, got 3 diamonds!");
            return 3;
        });

        ScheduleService.BukkitPromise<Object> mineB = scheduler.callAsync(plugin, () -> {
            commandSender.sendMessage("Mining B area, need 10 seconds...");
            Thread.sleep(10000);
            commandSender.sendMessage("B area mined, got 17 diamonds!");
            return 17;
        });

        commandSender.sendMessage("start mining....");

        scheduler.callAllAsync(plugin, List.of(mineA, mineB)).thenRunSync(results -> {

            var a = (int) results[0];
            var b = (int) results[1];

            commandSender.sendMessage(MessageFormat.format("mining finished!, we totally got {0} diamonds!", a + b));

        }).join();

    }
}
