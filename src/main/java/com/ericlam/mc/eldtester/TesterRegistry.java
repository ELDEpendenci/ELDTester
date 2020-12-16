package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.registrations.CommandRegistry;
import com.ericlam.mc.eld.registrations.ComponentsRegistry;
import com.ericlam.mc.eld.registrations.ListenerRegistry;
import com.ericlam.mc.eldtester.command.*;

import java.util.List;

public class TesterRegistry implements ComponentsRegistry {


    @Override
    public void registerCommand(CommandRegistry commandRegistry) {
        commandRegistry.command(TestCommand.class, c -> {

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

            c.command(TestBookCommand.class, cc ->{

                cc.command(TestBookCheckCommand.class);

                cc.command(TestBookReloadCommand.class);

            });

            c.command(TestSchedulerCommand.class, cc ->{

                cc.command(TestSchedulerOneCommand.class);

                cc.command(TestSchedulerTwoCommand.class);

            });

            c.command(TestLogCommand.class);
        });
    }

    @Override
    public void registerListeners(ListenerRegistry listenerRegistry) {
        listenerRegistry.listeners(List.of(
                TestListeners.class
        ));
        listenerRegistry.ELDListeners(List.of(
                TestELDListener.class
        ));
    }


}
