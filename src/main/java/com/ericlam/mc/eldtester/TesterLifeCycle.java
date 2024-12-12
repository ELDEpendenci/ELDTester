package com.ericlam.mc.eldtester;

import javax.inject.Inject;

import org.bukkit.plugin.java.JavaPlugin;

import com.ericlam.mc.eld.bukkit.ELDLifeCycle;

public class TesterLifeCycle implements ELDLifeCycle {

	@Inject
	private ClientFactory factory;

	@Override
	public void onEnable(JavaPlugin javaPlugin) {
		Client client = factory.createClient("Eric");
		client.sayHello();
		client.sayBye();

		SayClient sayClient = factory.createHelloClient("Leo");
		sayClient.say();

		sayClient = factory.createByeClient("PuiPui");
		sayClient.say();
	}

	@Override
	public void onDisable(JavaPlugin javaPlugin) {
	}
}
