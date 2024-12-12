package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.BukkitManagerProvider;
import com.ericlam.mc.eld.ELDBukkit;
import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ServiceCollection;


@ELDBukkit(lifeCycle = TesterLifeCycle.class)
public class ELDTester extends ELDBukkitPlugin {


	@Override
	public void bindServices(ServiceCollection serviceCollection) {
		serviceCollection.bindFactory(ClientFactory.class, TestClient.class, HelloClient.class, ByeClient.class);
	}

	@Override
	protected void manageProvider(BukkitManagerProvider bukkitManagerProvider) {
	}

}
