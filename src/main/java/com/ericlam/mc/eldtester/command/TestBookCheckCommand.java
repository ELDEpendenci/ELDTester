package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eld.services.ConfigPoolService;
import com.ericlam.mc.eldtester.BookConfig;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;

@Commander(
        name = "check",
        description = "book chceck command"
)
public class TestBookCheckCommand implements CommandNode {

    @Inject
    private ConfigPoolService service;

    @CommandArg(order = 0)
    private String book;

    @Override
    public void execute(CommandSender commandSender) {
        commandSender.sendMessage("book config cached: "+service.isPoolCached(BookConfig.class));
        service.getPoolAsync(BookConfig.class).thenRunSync(map -> {
            if (!map.containsKey(book)) {
                commandSender.sendMessage("book "+book+" is not exist.");
                return;
            }
            var bookContent = map.get(book);
            commandSender.sendMessage("id: "+bookContent.getId());
            commandSender.sendMessage("書名: "+ bookContent.title);
            commandSender.sendMessage("作者: "+bookContent.author);
            commandSender.sendMessage("書本簡介: "+bookContent.description);
            commandSender.sendMessage("書本總頁數: "+bookContent.pages);
            commandSender.sendMessage("書本內容: ");
            for (int i = 0; i < bookContent.contents.size(); i++) {
                commandSender.sendMessage(i+1+": "+bookContent.contents.get(i));
            }
        }).join();
    }
}
