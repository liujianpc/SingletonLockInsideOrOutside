package com.jigle.singleton;

public class Singleton {
	private static Singleton instance = null;

	private Singleton() throws InterruptedException {
		Thread.sleep(3000);
	}

	public static Singleton getInstance() throws InterruptedException {
		long start = System.currentTimeMillis();
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("lock inside=" + end+"-" +start +"="+(end- start)+"and isntance is"+instance);
		return instance;
	}
}
