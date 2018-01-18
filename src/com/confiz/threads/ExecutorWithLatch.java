package com.confiz.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorWithLatch implements Runnable {

	private CountDownLatch latch;
	
	private int id;

	public ExecutorWithLatch(CountDownLatch latch, int id) {
		this.latch = latch;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Thread " + id + " Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + id + " Completed");

		latch.countDown();

	}

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(10);

		ExecutorService execute = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {
			execute.submit(new ExecutorWithLatch(latch, i));
		}

		execute.shutdown();

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
	}

}
