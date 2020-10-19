package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.ELDLifeCycle;
import com.ericlam.mc.eld.services.ConfigPoolService;
import com.ericlam.mc.eld.services.ScheduleService;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class TesterLifeCycle implements ELDLifeCycle {


    @Inject
    private ScheduleService scheduler;

    @Inject
    private ConfigPoolService configPool;

    @Override
    public void onEnable(JavaPlugin javaPlugin) {
        javaPlugin.getLogger().info("before async is primary thread: " + Bukkit.getServer().isPrimaryThread());
        javaPlugin.getLogger().info("CompletableFuture: ");
        CompletableFuture.runAsync(() -> {
            javaPlugin.getLogger().info("hello world async !!");
        }).whenComplete((v, ex) -> {
            if (ex != null) ex.printStackTrace();
            javaPlugin.getLogger().info("Primary Thread: " + Bukkit.getServer().isPrimaryThread());
        }).join();
        javaPlugin.getLogger().info("Bukkit Promise: ");
        scheduler.runAsync(ELDTester.getPlugin(ELDTester.class), () -> {
            javaPlugin.getLogger().info("hello world!");
        }).thenRunSync(e -> {
            javaPlugin.getLogger().info("Primary Thread: " + Bukkit.getServer().isPrimaryThread());
        }).join();
    }

    @Override
    public void onDisable(JavaPlugin javaPlugin) {

    }
}
