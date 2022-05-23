package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.bukkit.ELDLifeCycle;
import com.ericlam.mc.eld.services.LoggingService;
import com.ericlam.mc.eldtester.sql.User;
import com.ericlam.mc.eldtester.sql.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Named;

public class TesterLifeCycle implements ELDLifeCycle {


    @Named("jpa")
    @Inject
    private UserService userService;

    @Inject
    private LoggingService loggingService;

    @Inject
    @Named("eld-json")
    private ObjectMapper jsonMapper;

    @Named("eld-yaml")
    @Inject
    private ObjectMapper yamlMapper;

    @Override
    public void onEnable(JavaPlugin javaPlugin) {

        javaPlugin.getLogger().info("json mapper is null: " + (jsonMapper == null));
        javaPlugin.getLogger().info("yaml mapper is null: " + (yamlMapper == null));

        var exist = userService.existByUsername("1234");
        javaPlugin.getLogger().info("exist 1234: " + exist);
        if (exist) {
            userService.deleteById("1234");
            javaPlugin.getLogger().info("after delete: ");
            userService.findAll().forEach(u -> javaPlugin.getLogger().info(u.toString()));
        }
        javaPlugin.getLogger().info("exist 1234: " + userService.existByUsername("1234"));


        // save
        var u = userService.findByUsername("1234").orElseGet(() -> {
            var user = new User();
            user.username = "1234";
            user.password = "1234";
            user.firstName = "Eric";
            user.lastName = "Lam";
            return user;
        });

        javaPlugin.getLogger().info("current: " + u);

        u.firstName = "Eric2";
        u.lastName = "Lam2";

        userService.save(u);

        var logger = loggingService.getLogger(ELDTester.class);
        logger.debug("this {0} is {1}", "logger", "debug logger");
        logger.debug(new Exception("this is a debug exception"), "this is a debug {0}", "exception");
        logger.info("this is a info message");
        logger.warn("this is a warn message");
    }

    @Override
    public void onDisable(JavaPlugin javaPlugin) {

    }
}
