package com.ericlam.mc.eldtester;

import javax.inject.Inject;

public class ByeClient {

	@Inject
	private ByeService byeService;

	private final String name;

	public ByeClient(String name) {
		this.name = name;
	}

	public void sayBye() {
		byeService.sayBye(name);
	}
}
