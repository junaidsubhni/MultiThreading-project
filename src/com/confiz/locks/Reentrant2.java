package com.confiz.locks;

public class Reentrant2 implements Runnable {

	Lock lock = new Lock();
	
	private int id;
	
	public Reentrant2(int id) {
		this.id = id;
	}

	public void outer() throws InterruptedException {
		lock.lock();
		System.out.println("outer method");
		inner();
		lock.unlock();
	}

	public synchronized void inner() throws InterruptedException {
		lock.lock();
		System.out.println("inner method");
		lock.unlock();
	}

	@Override
	public void run() {
		System.out.println("Thread " + id + " Started");
		try {
			outer();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + id + " Completed");
	}
}