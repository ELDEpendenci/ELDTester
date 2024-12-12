package com.ericlam.mc.eldtester;

import javax.inject.Inject;
import javax.inject.Named;

@Named("hello")
public class HelloClient implements SayClient {

	@Inject
	private HelloService helloService;

	private final String name;

	public HelloClient(String name) {
		this.name = name;
	}

	@Override
	public void say() {
		helloService.sayHello(name);
	}

}
