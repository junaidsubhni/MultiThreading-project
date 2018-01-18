package com.confiz.locks;

public class LockPractice {

	private int count = 0;
	
	Lock lock = new Lock();
	
	public void increament() {
		try {
			lock.lock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		lock.unlock();
	}

	public static void main(String[] args) {
		LockPractice app = new LockPractice();
		app.doProcess();

	}

	private void doProcess() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					increament();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					increament();
				}

			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Value 0f Count: " + count);

	}

}
