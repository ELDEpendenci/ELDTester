package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eldtester.I18nService;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.inject.Inject;

@Commander(
        name = "lang",
        description = "test language command"
)
public class TestLanguageCommand implements CommandNode {


    @Inject
    private I18nService i18nService;

    @CommandArg(order = 0)
    private Player player;

    @CommandArg(order = 1)
    private String path;

    @Override
    public void execute(CommandSender commandSender) {
        i18nService.sendMessage(player, path);
    }
}
