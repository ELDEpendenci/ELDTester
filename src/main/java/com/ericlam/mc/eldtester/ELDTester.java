package com.ericlam.mc.eldtester;

import chu77.eldependenci.sql.EntityRegistration;
import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ManagerProvider;
import com.ericlam.mc.eld.ServiceCollection;
import com.ericlam.mc.eld.annotations.ELDPlugin;
import com.ericlam.mc.eldtester.sql.EldTesterRegistration;
import com.ericlam.mc.eldtester.sql.UserService;

import java.util.Map;


@ELDPlugin(
        registry = TesterRegistry.class,
        lifeCycle = TesterLifeCycle.class
)
public class ELDTester extends ELDBukkitPlugin {


    public static final String MY_TAG = "ELD_TESTER";

    @Override
    protected void bindServices(ServiceCollection serviceCollection) {
        serviceCollection.addConfiguration(TestConfig.class);
        serviceCollection.addGroupConfiguration(BookConfig.class);
        serviceCollection.addSingleton(TesterSingleton.class);
        serviceCollection.addMultipleLanguages(TesterMultiLang.class);
        serviceCollection.bindService(I18nService.class, I18nServiceImpl.class);


        serviceCollection.addServices(EntityRegistration.class, Map.of(
                MY_TAG, EldTesterRegistration.class
        ));

        serviceCollection.addSingleton(UserService.class);
    }

    @Override
    protected void manageProvider(ManagerProvider provider) {

    }
}
