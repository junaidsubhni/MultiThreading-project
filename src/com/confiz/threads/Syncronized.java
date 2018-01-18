package com.confiz.threads;

public class Syncronized {

	private int count = 0;
	
	public synchronized void increament() {
		count++;
	}

	public static void main(String[] args) {
		Syncronized app = new Syncronized();
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
