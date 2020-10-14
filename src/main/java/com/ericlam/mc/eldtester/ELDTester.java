package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ManagerProvider;
import com.ericlam.mc.eld.ServiceCollection;
import com.ericlam.mc.eld.annotations.ELDPlugin;
import com.ericlam.mc.eld.exceptions.ArgumentParseException;

import java.util.Map;


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
        serviceCollection.addServices(StorageService.class, Map.of("mysql", MySQLStorageService.class, "yaml", YamlStorageService.class));
        serviceCollection.addSingleton(TesterSingleton.class);
        serviceCollection.addService(IService.class, IServiceImpl.class);
    }

    @Override
    protected void manageProvider(ManagerProvider provider) {
        var parser = provider.getArgumentManager();
        parser.registerParser(String.class, "message", (iterator, commandSender, p) -> {
            StringBuilder builder = new StringBuilder();
            iterator.forEachRemaining(s -> builder.append(s).append(" "));
            return builder.toString();
        });
        parser.registerParser(Integer.class, ((iterator, commandSender, argParser) -> {
            try{
                return Integer.parseInt(iterator.next());
            }catch (NumberFormatException e){
                throw new ArgumentParseException("不是有效的 integer.");
            }
        }));
    }
}
