package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.annotations.InjectPool;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eld.configurations.GroupConfig;
import com.ericlam.mc.eld.configurations.PageRequest;
import com.ericlam.mc.eld.services.ScheduleService;
import com.ericlam.mc.eldtester.Book;
import com.ericlam.mc.eldtester.ELDTester;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import javax.inject.Inject;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.function.Predicate;

@Commander(
        name = "page",
        description = "pagination test for books"
)
public class TestBookPageCommand implements CommandNode {

    private static final Predicate<Path> NO_START_WITH_B = path -> !path.getFileName().toString().startsWith("b");
    private static final Predicate<Path> NO_START_WITH_A = path -> !path.getFileName().toString().startsWith("a");

    @InjectPool
    private GroupConfig<Book> groupConfig;

    @Inject
    private ScheduleService scheduleService;

    @Inject
    private ELDTester plugin;

    @CommandArg(order = 1)
    private int page;

    @CommandArg(order = 2, optional = true)
    private boolean showContent = false;

    @CommandArg(order = 3, optional = true)
    private int size = 10;

    @Override
    public void execute(CommandSender commandSender) {
        int index = Math.max(0, page - 1);
        groupConfig.fetch(); // dangerous! may slow down your performance
        scheduleService.callAsync(plugin, () -> groupConfig.findAll(PageRequest.of(index, size, NO_START_WITH_B)))
                .thenRunSync(page -> {
                    commandSender.sendMessage("page size: "+page.getContent().size());
                    page.getContent().forEach(book -> commandSender.sendMessage(showContent ? book.toString() : book.getId()));
                    commandSender.sendMessage(MessageFormat.format("page {0} / {1}, Total Elements: {2}", page.getCurrentPage()+1, page.getTotalPages(), page.getTotalElements()));
                }).join();
    }
}
