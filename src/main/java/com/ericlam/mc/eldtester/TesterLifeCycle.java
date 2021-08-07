package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDLifeCycle;
import com.ericlam.mc.eldtester.sql.User;
import com.ericlam.mc.eldtester.sql.UserService;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Named;

public class TesterLifeCycle implements ELDLifeCycle {


    @Named("jpa")
    @Inject
    private UserService userService;

    @Override
    public void onEnable(JavaPlugin javaPlugin) {
        javaPlugin.getLogger().info("exist 1234: "+userService.existByUsername("1234"));
        userService.deleteById("1234");
        javaPlugin.getLogger().info("after delete: ");
        userService.findAll().forEach(u -> javaPlugin.getLogger().info(u.toString()));
        javaPlugin.getLogger().info("exist 1234: "+userService.existByUsername("1234"));
        User user = new User();
        user.username = "1234";
        user.password = "1234";
        user.lastName = "A";
        user.firstName = "B";
        userService.save(user);
        javaPlugin.getLogger().info("after create: ");
        userService.findAll().forEach(u -> javaPlugin.getLogger().info(u.toString()));
    }

    @Override
    public void onDisable(JavaPlugin javaPlugin) {

    }
}
