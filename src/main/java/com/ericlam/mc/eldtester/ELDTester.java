package com.ericlam.mc.eldtester;

import chu77.eldependenci.sql.SQLInstallation;
import com.ericlam.mc.eld.BukkitManagerProvider;
import com.ericlam.mc.eld.ELDBukkit;
import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ServiceCollection;
import com.ericlam.mc.eldgui.MVCInstallation;
import com.ericlam.mc.eldtester.gui.*;
import com.ericlam.mc.eldtester.sql.*;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Map;


@ELDBukkit(
        registry = TesterRegistry.class,
        lifeCycle = TesterLifeCycle.class
)
public class ELDTester extends ELDBukkitPlugin {


    @Override
    public void bindServices(ServiceCollection serviceCollection) {

        serviceCollection.addConfiguration(TestConfig.class);
        serviceCollection.addGroupConfiguration(Book.class);
        serviceCollection.addGroupConfiguration(GUITemplate.class);
        serviceCollection.addSingleton(TesterSingleton.class);
        serviceCollection.addMultipleLanguages(TesterMultiLang.class);
        serviceCollection.bindService(I18nService.class, I18nServiceImpl.class);


        serviceCollection.addServices(UserService.class, Map.of(
                "jpa", UserJpaService.class,
                "em", UserEMService.class
        ));

        serviceCollection.bindServiceProvider(Animal.class, AnimalProvider.class);

        SQLInstallation sql = serviceCollection.getInstallation(SQLInstallation.class);

        sql.bindEntities(User.class);
        sql.bindJpaRepository(UserRepository.class, CustomARepoImpl.class, CustomBRepoImpl.class);

        MVCInstallation mvc = serviceCollection.getInstallation(MVCInstallation.class);
        mvc.registerControllers(MainController.class); // 註冊 Controller
        mvc.registerQualifier(MyOwnFilter.class, (interactEvent, pattern, myOwnFilter) -> {
            if (!(interactEvent instanceof InventoryClickEvent clickEvent)) return false;
            return clickEvent.getClick() == myOwnFilter.type();
        });
        mvc.addComponentFactory(PasswordFieldFactory.class, PasswordFieldFactoryImpl.class);
    }

    @Override
    protected void manageProvider(BukkitManagerProvider bukkitManagerProvider) {

    }
}
