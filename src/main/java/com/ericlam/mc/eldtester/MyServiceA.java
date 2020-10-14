package com.ericlam.mc.eldtester;

import org.bukkit.command.CommandSender;

public class MyServiceA implements MyService {


    @Override
    public void sayHelloTo(CommandSender sender) {
        sender.sendMessage("hello world A!!!");
    }

    @Override
    public void sayGoodBye(CommandSender sender) {
        sender.sendMessage("good bye A!!!");
    }
}
