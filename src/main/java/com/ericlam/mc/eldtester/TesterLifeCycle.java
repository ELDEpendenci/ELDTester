package com.ericlam.mc.eldtester;

import javax.inject.Inject;

import org.bukkit.plugin.java.JavaPlugin;

import com.ericlam.mc.eld.bukkit.ELDLifeCycle;

public class TesterLifeCycle implements ELDLifeCycle {

	@Inject
	private ClientFactory factory;

	@Override
	public void onEnable(JavaPlugin javaPlugin) {
		var client = factory.createClient("Eric");
		client.sayHello();
		client.sayBye();
	}

	@Override
	public void onDisable(JavaPlugin javaPlugin) {
	}
}
