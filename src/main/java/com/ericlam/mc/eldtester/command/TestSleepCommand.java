package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.annotations.DynamicArg;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eld.services.ScheduleService;
import com.ericlam.mc.eldtester.ELDTester;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import javax.inject.Inject;

@Commander(
        name = "sleep",
        description = "sleep command"
)
public class TestSleepCommand implements CommandNode {


    @DynamicArg(order = 0, types = { Long.class, String.class })
    private Object seconds;

    @Inject
    private ScheduleService scheduleService;

    @Override
    public void execute(CommandSender commandSender) {
        if (seconds instanceof Long){
            commandSender.sendMessage("sleeping...");
            var time = (Long) seconds;
            scheduleService.injectTask(new BukkitRunnable() {
                @Override
                public void run() {
                    commandSender.sendMessage("you wake up!");
                    commandSender.sendMessage("you just slept "+seconds+" seconds!");
                }
            }).timeout(time * 20L).run(ELDTester.getPlugin(ELDTester.class));
        }else if (seconds instanceof String){
            var time = (String) seconds;
            switch (time.toLowerCase()){
                case "never":
                    commandSender.sendMessage("you don't sleep ? okay you never sleep");
                    return;
                case "forever":
                    commandSender.sendMessage("you sleep forever ? that's not good!");
                    return;
                default:
                    commandSender.sendMessage("oh sorry what is "+time+" ? I don't understand.");
            }
        }
    }
}
