package com.ericlam.mc.eldtester;

import javax.inject.Inject;
import javax.inject.Named;

@Named("bye")
public class ByeClient implements SayClient {

	@Inject
	private ByeService byeService;

	private final String name;

	public ByeClient(String name) {
		this.name = name;
	}

	@Override
	public void say() {
		byeService.sayBye(name);
	}
}
