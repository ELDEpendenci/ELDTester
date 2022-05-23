package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.annotations.InjectPool;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.configurations.GroupConfig;
import com.ericlam.mc.eld.services.ScheduleService;
import com.ericlam.mc.eldtester.Book;
import com.ericlam.mc.eldtester.ELDTester;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "delete",
        description = "delete book"
)
public class TestBookDeleteCommand  implements CommandNode {

    @Inject
    private ScheduleService scheduleService;

    @Inject
    private ELDTester plugin;

    @InjectPool
    private GroupConfig<Book> groupConfig;


    @CommandArg(order = 1)
    private String id;

    @Override
    public void execute(CommandSender sender) {
        scheduleService
                .callAsync(plugin, () -> groupConfig.deleteById(id))
                .thenRunSync(result -> sender.sendMessage("delete "+(result ? "success" : "failed"))).join();
    }
}
