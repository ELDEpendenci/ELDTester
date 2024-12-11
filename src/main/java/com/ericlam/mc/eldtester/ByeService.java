package com.ericlam.mc.eldtester;

import javax.inject.Inject;

public class ByeService {

	@Inject
	private PrintService printService;

	public void sayBye(String who) {
		printService.print("Bye, " + who);
	}
}
