package com.confiz.locks;

public class Reentrant implements Runnable {

	private int id;
	
	public Reentrant(int id) {
		this.id = id;
	}
	public synchronized void outer(){
		System.out.println("outer method");
		inner();
	  }

	public synchronized void inner(){
	    System.out.println("inner method");
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