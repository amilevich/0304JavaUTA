package com.example.threads;

public class Main {

	public static void main(String[] args) {

		Thread worker = new FirstThreadExample();
		Thread manager = new Thread(new MyRunnable());
		
		manager.start();
		worker.start();
		
		//worker.run(); 
		// run method will not create a separate thread
		
		//threads are always sequential
		
		for(int i=0; i<20; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
