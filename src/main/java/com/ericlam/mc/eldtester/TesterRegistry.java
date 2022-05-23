package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.bukkit.CommandNode;
import com.ericlam.mc.eld.bukkit.ComponentsRegistry;
import com.ericlam.mc.eld.registration.CommandRegistry;
import com.ericlam.mc.eld.registration.ListenerRegistry;
import com.ericlam.mc.eldtester.command.*;
import org.bukkit.event.Listener;

import java.util.List;

public class TesterRegistry implements ComponentsRegistry {


    @Override
    public void registerListeners(ListenerRegistry<Listener> listenerRegistry) {
        listenerRegistry.listeners(List.of(TestListeners.class));
    }


    @Override
    public void registerCommand(CommandRegistry<CommandNode> commandRegistry) {
        commandRegistry.command(TestCommand.class, c -> {

            c.command(TestGUICommand.class);

            c.command(TestLanguageCommand.class);

            c.command(TestSayCommand.class);

            c.command(TestCalculateCommand.class, cc -> {

                cc.command(TestCalculateAddCommand.class);

                cc.command(TestCalculateMinusCommand.class);

            });

            c.command(TestConfigCommand.class, cc -> {

                cc.command(TestConfigCheckCommand.class);

                cc.command(TestConfigEditCommand.class);

                cc.command(TestConfigReloadCommand.class);

            });

            c.command(TestSleepCommand.class);

            c.command(TestBookCommand.class, cc -> {

                cc.command(TestBookCheckCommand.class);

                cc.command(TestBookReloadCommand.class);

                cc.command(TestBookAddCommand.class);

                cc.command(TestBookDeleteCommand.class);

                cc.command(TestBookGenerateCommand.class);

                cc.command(TestBookPageCommand.class);

            });

            c.command(TestSchedulerCommand.class, cc -> {

                cc.command(TestSchedulerOneCommand.class);

                cc.command(TestSchedulerTwoCommand.class);

                cc.command(TestSchedulerThreeCommand.class);

                cc.command(TestSchedulerFourCommand.class);

            });

            c.command(TestLogCommand.class);
        });
    }
}
