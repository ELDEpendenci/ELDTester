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
import java.util.ArrayList;
import java.util.Random;

@Commander(
        name = "generate",
        description = "generate books"
)
public class TestBookGenerateCommand implements CommandNode {


    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();

    @InjectPool
    private GroupConfig<Book> bookGroupConfig;

    @Inject
    private ScheduleService scheduleService;
    @Inject
    private ELDTester plugin;

    @CommandArg(order = 1)
    private int amount;

    @Override
    public void execute(CommandSender commandSender) {
        scheduleService.runAsync(plugin, () -> {
            for (int i = 0; i < amount; i++) {
                Book book = new Book();
                StringBuilder stringBuilder = new StringBuilder();
                for (int l = 0; l < 5; l++) {
                    stringBuilder.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
                }
                book.setId(stringBuilder.toString());
                book.author = "Author: "+i;
                book.title = "Book no. "+i;
                book.description = "this is a book with index "+i;
                book.contents = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    book.contents.add("This is content: "+j);
                }
                bookGroupConfig.save(book);
            }
        }).thenRunSync(v -> commandSender.sendMessage(amount+" books generated.")).join();
    }
}
