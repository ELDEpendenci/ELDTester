package com.ericlam.mc.eldtester;

import org.bukkit.command.CommandSender;

public class MyServiceB implements MyService{

    @Override
    public void sayHelloTo(CommandSender sender) {
        sender.sendMessage("hello world B!!!");
    }

    @Override
    public void sayGoodBye(CommandSender sender) {
        sender.sendMessage("good bye B!!!");
    }

}
