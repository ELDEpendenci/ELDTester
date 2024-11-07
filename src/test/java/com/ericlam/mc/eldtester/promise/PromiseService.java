package com.ericlam.mc.eldtester.promise;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class PromiseService {



	public CompletableFuture<Void> run(Runnable runnable) {
		return CompletableFuture.runAsync(runnable);
	}
}
