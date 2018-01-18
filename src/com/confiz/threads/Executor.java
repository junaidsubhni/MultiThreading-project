package com.confiz.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor implements Runnable {

	private int id;

	public Executor(int id) {
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
	}

	public static void main(String[] args) {

		ExecutorService execute = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 10; i++) {
			execute.submit(new Executor(i));
		}

		execute.shutdown();

		System.out.println("All Tasks submitted");

		try {
			//wait for specific amount of time before termination
			execute.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
	}

}
