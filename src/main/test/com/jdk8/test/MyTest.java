package com.jdk8.test;

import org.junit.Test;

public class MyTest {

	@Test
	public void test() {
		System.out.println(1 << 4);//0000 0001 -> 0001 0000
	}
	
	@Test
	public void test2() throws InterruptedException {
		ThreadLocal<String> names = new ThreadLocal<>();
		
		names.set("zhangsan");
		//System.out.println(names.get());
		new Thread(() -> {
			System.out.println(names.get());
		}).start();
		
		Thread.sleep(2000);
		new Thread(() -> {
			System.out.println(names.get());
		}).start();
	}
}
