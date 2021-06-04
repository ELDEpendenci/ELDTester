package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.CommandArg;
import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.components.CommandNode;
import com.ericlam.mc.eldtester.TesterMultiLang;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;
import java.util.Map;

@Commander(
        name = "lang",
        description = "test language command"
)
public class TestLanguageCommand implements CommandNode {


    @Inject
    private Map<String, TesterMultiLang> multiLangMap;

    @CommandArg(order = 1)
    private String language;

    @Override
    public void execute(CommandSender commandSender) {
        TesterMultiLang multiLang = multiLangMap.get(language);
        if (multiLang == null){
            commandSender.sendMessage("unknown language");
        }else{
            commandSender.sendMessage(multiLang.getLang().get("first"));
            commandSender.sendMessage(multiLang.getLang().get("second"));
            commandSender.sendMessage(multiLang.getLang().get("third"));
        }
    }
}
