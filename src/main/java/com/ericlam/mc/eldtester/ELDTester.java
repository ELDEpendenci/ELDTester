package com.ericlam.mc.eldtester;

import chu77.eldependenci.sql.SQLInstallation;
import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ManagerProvider;
import com.ericlam.mc.eld.ServiceCollection;
import com.ericlam.mc.eld.annotations.ELDPlugin;
import com.ericlam.mc.eldtester.sql.*;

import java.util.Map;


@ELDPlugin(
        registry = TesterRegistry.class,
        lifeCycle = TesterLifeCycle.class
)
public class ELDTester extends ELDBukkitPlugin {


    @Override
    protected void bindServices(ServiceCollection serviceCollection) {
        serviceCollection.addConfiguration(TestConfig.class);
        serviceCollection.addGroupConfiguration(BookConfig.class);
        serviceCollection.addSingleton(TesterSingleton.class);
        serviceCollection.addMultipleLanguages(TesterMultiLang.class);
        serviceCollection.bindService(I18nService.class, I18nServiceImpl.class);


        serviceCollection.addServices(UserService.class, Map.of(
                "jpa", UserJpaService.class,
                "em", UserEMService.class
        ));

        serviceCollection.bindServiceProvider(Animal.class, AnimalProvider.class);

        SQLInstallation sql = serviceCollection.getInstallation(SQLInstallation.class);
        sql.bindRepository(User.class, UserRepository.class);

    }

    @Override
    protected void manageProvider(ManagerProvider provider) {

    }
}
