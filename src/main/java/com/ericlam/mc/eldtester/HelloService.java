package com.ericlam.mc.eldtester;

import javax.inject.Inject;

public class HelloService {

	@Inject
	private PrintService printService;

	public void sayHello(String who) {
		printService.print("Hello, " + who);
	}

}
