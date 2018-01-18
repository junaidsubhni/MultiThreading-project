package com.confiz.threads;

public class Philosopher implements Runnable {

	private final Object leftFork;
	private final Object rightFork;

	Philosopher(Object left, Object right) {
		this.leftFork = left;
		this.rightFork = right;
	}

	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep(4000);
	}

	@Override
	public void run() {
		try {
			while (true) {
				doAction(": Thinking"); // thinking
				synchronized (leftFork) {
					doAction(": Picked up left fork");
					synchronized (rightFork) {
						doAction(": Picked up right fork - eating"); // eating
						doAction(": Put down right fork");
					}
					doAction(": Put down left fork. Returning to thinking");
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}