package com.ericlam.mc.eldtester;

import org.bukkit.command.CommandSender;

import javax.inject.Inject;

public class IServiceImpl implements IService{

    @Inject
    private TestConfig config;

    @Override
    public void doSomething(CommandSender sender) {
        sender.sendMessage(config.name);
    }
}
