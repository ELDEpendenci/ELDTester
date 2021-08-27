package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.annotations.InjectPool;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eld.configurations.GroupLang;
import com.ericlam.mc.eldtester.TesterMultiLang;
import org.bukkit.command.CommandSender;

@Commander(
        name = "lang",
        description = "test language command"
)
public class TestLanguageCommand implements CommandNode {


    /*
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

     */
    @InjectPool
    private GroupLang<TesterMultiLang> multiLangGroupLang;

    @CommandArg(order = 1)
    private String language;

    @Override
    public void execute(CommandSender commandSender) {
        var multiLangOpt = multiLangGroupLang.getByLocale(language);
        if (multiLangOpt.isEmpty()){
            commandSender.sendMessage("unknown language");
            return;
        }
        var multiLang = multiLangOpt.get();
        commandSender.sendMessage(multiLang.getLang().get("first"));
        commandSender.sendMessage(multiLang.getLang().get("second"));
        commandSender.sendMessage(multiLang.getLang().get("third"));
    }
}
