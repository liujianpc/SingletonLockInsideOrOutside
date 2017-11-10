package com.jigle.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingletonAddLockEffecy {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		ExecutorService executorService1 = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub

					try {
						Singleton instance = Singleton.getInstance();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});

		}
		for (int i = 0; i < 10; i++) {
			executorService1.execute(new Runnable() {

				@Override
				public void run() {

					try {
						SingletonLockOut otherInstance = SingletonLockOut.getInstance();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
		}

	}

}
