package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.annotations.InjectPool;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.configurations.GroupConfig;
import com.ericlam.mc.eldtester.Book;
import org.bukkit.command.CommandSender;

@Commander(
        name = "reload",
        description = "book reload"
)
public class TestBookReloadCommand implements CommandNode {

    @InjectPool
    private GroupConfig<Book> groupConfig;

    @Override
    public void execute(CommandSender commandSender) {
        groupConfig.fetch();
        commandSender.sendMessage("reloaded");
    }
}
