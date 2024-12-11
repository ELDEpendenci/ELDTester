package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.annotations.InjectLogger;
import com.ericlam.mc.eld.misc.DebugLogger;

public class PrintService {

	@InjectLogger
	private DebugLogger logger;

	public void print(String message) {
		logger.info(message);
	}

}
