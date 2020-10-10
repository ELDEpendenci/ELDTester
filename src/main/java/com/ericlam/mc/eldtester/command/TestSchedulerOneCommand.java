package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eld.services.ScheduleService;
import com.ericlam.mc.eldtester.ELDTester;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import javax.inject.Inject;

@Commander(
        name = "one",
        description = "one scheduler"
)
public class TestSchedulerOneCommand implements CommandNode {


    @Inject
    private ScheduleService service;

    @Override
    public void execute(CommandSender commandSender) {
        commandSender.sendMessage("wait for 5 secs");
        service.injectTask(new BukkitRunnable() {

            @Inject
            private ScheduleService service;

            @Override
            public void run() {
                commandSender.sendMessage("scheduler service instance inside bukkit runnable is "+(service == null ? "null" : "not null !"));
            }

        }).asynchronous(false)
        .timeout(100L)
        .run(ELDTester.getProvidingPlugin(ELDTester.class));
    }
}
