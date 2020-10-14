package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ManagerProvider;
import com.ericlam.mc.eld.ServiceCollection;
import com.ericlam.mc.eld.annotations.ELDPlugin;
import com.ericlam.mc.eld.exceptions.ArgumentParseException;

import java.util.Map;
import java.util.regex.Pattern;


@ELDPlugin(
        registry = TesterRegistry.class,
        lifeCycle = TesterLifeCycle.class
)
public class ELDTester extends ELDBukkitPlugin {

    @Override
    protected void bindServices(ServiceCollection serviceCollection) {
        serviceCollection.addConfiguration(TestConfig.class);
        serviceCollection.addServices(MyService.class, Map.of(
                "A", MyServiceA.class,
                "B", MyServiceB.class
        ));
        serviceCollection.addSingleton(TesterSingleton.class);
    }

    @Override
    protected void manageProvider(ManagerProvider provider) {
        var parser = provider.getArgumentManager();
        parser.registerParser(String.class, "a-z", ((iterator, commandSender, p) -> {
            String arg = iterator.next();
            var result = Pattern.compile("^[a-z]*$").matcher(arg);
            if (result.find()){
                return result.group();
            }else{
                throw new ArgumentParseException("cannot find");
            }
        }));
    }
}
