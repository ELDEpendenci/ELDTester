package com.ericlam.mc.eldtester;

import javax.inject.Inject;

public class TestClient implements Client {

	@Inject
	private HelloService helloService;
	@Inject
	private ByeService byeService;

	private final String name;

	public TestClient(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		helloService.sayHello(name);
	}

	@Override
	public void sayBye() {
		byeService.sayBye(name);
	}

}
