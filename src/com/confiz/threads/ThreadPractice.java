package com.confiz.threads;

public class ThreadPractice extends Thread {
	public void run() {
		for (int i = 1; i < 5; i++) {
			
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		ThreadPractice t1 = new ThreadPractice();
		ThreadPractice t2 = new ThreadPractice();

//		t1.run();
//		t2.run();
		
		t1.start();
		t2.start();
		
	}
}