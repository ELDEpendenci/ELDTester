package com.ericlam.mc.eldtester;

import javax.inject.Inject;

public class HelloClient {

	@Inject
	private HelloService helloService;

	private final String name;

	public HelloClient(String name) {
		this.name = name;
	}

	public void sayHello() {
		helloService.sayHello(name);
	}
}
