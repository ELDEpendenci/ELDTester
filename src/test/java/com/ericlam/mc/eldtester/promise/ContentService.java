package com.ericlam.mc.eldtester.promise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.AsyncResult;

public class ContentService {

	@Promise
	public Future<String> retriveContent(String url) throws Exception {
		Thread.sleep(5000);
		return new AsyncResult<>("This is the content of " + url);
	}

	public Future<Void> printContent() throws Exception {
		var content = retriveContent("https://google.com").get();
		return CompletableFuture.runAsync(() -> System.out.println("content: " + content));
	}
}
