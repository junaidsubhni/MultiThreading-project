package com.confiz.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LockPractice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		ExecutorService execute = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			execute.submit(new Reentrant(i));
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
		
		System.out.println("All Tasks Completed");

	}

}
