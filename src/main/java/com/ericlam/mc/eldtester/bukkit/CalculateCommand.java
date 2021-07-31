package com.ericlam.mc.eldtester.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Locale;

public class CalculateCommand implements CommandExecutor {

    private boolean showHelp(CommandSender sender){
        sender.sendMessage("/test calculate add <one> [two]");
        sender.sendMessage("/test calculate minus <one> [two]");
        sender.sendMessage("/test say <message>");
        return true;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length < 2) return showHelp(commandSender);
        switch (strings[0].toLowerCase(Locale.ROOT)){
            case "say":
                String message = String.join(" ", Arrays.copyOfRange(strings, 1, strings.length));
                Bukkit.broadcastMessage(commandSender.getName()+" say: "+message);
                break;
            case "calculate":
                if (strings.length < 3) return showHelp(commandSender);
                try{
                    int one = Integer.parseInt(strings[2]);
                    int two = Integer.parseInt(strings.length > 3 ? strings[3] : "0"); // 默認是 0
                    String msg;
                    switch (strings[1].toLowerCase(Locale.ROOT)){
                        case "add":
                            msg = one + " + " + two + " = " + (one + two);
                            break;
                        case "minus":
                            msg = one + " - " + two + " = " + (one - two);
                            break;
                        default:
                            return showHelp(commandSender);
                    }
                    commandSender.sendMessage(msg);
                }catch (NumberFormatException e){
                    commandSender.sendMessage("not a number!");
                }
                break;
            default:
                showHelp(commandSender);
                break;
        }

        return true;
    }
}
