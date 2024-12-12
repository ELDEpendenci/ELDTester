package com.ericlam.mc.eldtester;

import java.util.Arrays;

public class EldTest {

	public interface IService {
		void sayHello(String who);
		void sayBye(String who);
	}

	public static class HelloService implements IService {
		@Override
		public void sayHello(String who) {
			System.out.println("Hello, " + who);
		}
		@Override
		public void sayBye(String who) {
			System.out.println("Bye, " + who);
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(HelloService.class.getInterfaces()));
		System.out.println(HelloService.class.getSuperclass());
	}
}
