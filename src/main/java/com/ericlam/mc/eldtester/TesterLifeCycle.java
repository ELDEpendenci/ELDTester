package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDLifeCycle;
import com.ericlam.mc.eldtester.sql.User;
import com.ericlam.mc.eldtester.sql.UserService;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import java.util.Map;

public class TesterLifeCycle implements ELDLifeCycle {


    @Inject
    private Map<String, Plugin> plugins;

    @Inject
    private UserService userService;

    @Override
    public void onEnable(JavaPlugin javaPlugin) {
        javaPlugin.getLogger().info(plugins.toString());

        javaPlugin.getLogger().info("======= Test SQL ===========");

        User user1 = new User();
        user1.username = "user1";
        user1.firstName = "Chan";
        user1.lastName = "Tai Man";
        user1.password = "chan1234";
        userService.save(user1);
        javaPlugin.getLogger().info("saved "+user1);

        User user2 = new User();
        user2.username = "user2";
        user2.firstName = "Chan";
        user2.lastName = "Siu Man";
        user2.password = "chan8976";
        userService.save(user2);
        javaPlugin.getLogger().info("saved "+user2);

        javaPlugin.getLogger().info("==== reading ====");
        userService.findAll().forEach(user -> javaPlugin.getLogger().info(user.toString()));
        javaPlugin.getLogger().info("==== reading ====");




        javaPlugin.getLogger().info("======= Test SQL ===========");
    }

    @Override
    public void onDisable(JavaPlugin javaPlugin) {

    }
}
