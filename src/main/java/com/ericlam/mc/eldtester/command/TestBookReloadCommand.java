package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eld.services.ConfigPoolService;
import com.ericlam.mc.eldtester.BookConfig;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "reload",
        description = "book reload"
)
public class TestBookReloadCommand implements CommandNode {

    @Inject
    private ConfigPoolService service;

    @Override
    public void execute(CommandSender commandSender) {
        service.reloadPool(BookConfig.class).whenComplete((v, ex) ->{
            if (ex != null) ex.printStackTrace();

            commandSender.sendMessage("reload completed!");
        });
    }
}
