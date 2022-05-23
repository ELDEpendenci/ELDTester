package com.ericlam.mc.eldtester.command;

import com.ericlam.mc.eld.annotations.Commander;
import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eldtester.TestConfig;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Commander(
        name = "edit",
        description = "config edit command"
)
public class TestConfigEditCommand  implements CommandNode {

    private final Random random = new Random();

    @Inject
    private TestConfig config;

    @Override
    public void execute(CommandSender commandSender) {
        config.bool = random.nextBoolean();
        config.name = UUID.randomUUID().toString();
        config.number = random.nextInt();

        try {
            config.getController().save();
            commandSender.sendMessage("save completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
