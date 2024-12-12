package com.ericlam.mc.eldtester;

import javax.inject.Named;

public interface ClientFactory {

	Client createClient(String name);

	@Named("hello")
	SayClient createHelloClient(String name);

	@Named("bye")
	SayClient createByeClient(String name);

}
