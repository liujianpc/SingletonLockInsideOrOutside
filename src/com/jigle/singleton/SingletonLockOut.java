package com.jigle.singleton;

public class SingletonLockOut {
	private static SingletonLockOut instance = null;
	private SingletonLockOut() throws InterruptedException {
		Thread.sleep(3000);
	}
	public static SingletonLockOut getInstance() throws InterruptedException {
		long start = System.currentTimeMillis();
		synchronized (SingletonLockOut.class) {
			if (instance == null) {
				instance = new SingletonLockOut();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("lock outside="+end+"-"+start+"=" + (end - start)+"and isntance is"+instance);
		return instance;
	}

}
