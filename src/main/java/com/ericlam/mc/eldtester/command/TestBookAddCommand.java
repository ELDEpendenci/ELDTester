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
import java.util.Arrays;

@Commander(
        name = "add",
        description = "add book"
)
public class TestBookAddCommand implements CommandNode {


    @InjectPool
    private GroupConfig<Book> groupConfig;

    @Inject
    private ScheduleService scheduleService;

    @Inject
    private ELDTester plugin;

    @CommandArg(order = 1)
    private String id;

    @CommandArg(order = 1, optional = true)
    private String author = "unknown";

    @Override
    public void execute(CommandSender sender) {
        Book book = new Book();
        book.setId(id); // 記得設置標識 id, 否則會報錯
        book.title = "This is a title with id "+id;
        book.author = author;
        book.description = "book with id "+id;
        book.contents = Arrays.asList("this", "is", "a", "content");

        scheduleService
                .runAsync(plugin, () -> groupConfig.save(book))
                .thenRunSync(v -> sender.sendMessage("save completed")).join();
    }
}
