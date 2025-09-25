package com.example.demo.creational.singleton;

public class ThreadSafe {

	private static volatile ThreadSafe instance;
	
	private ThreadSafe() {}
	
	private static synchronized ThreadSafe getInstance() {
		if(instance == null) 
			instance = new ThreadSafe();
		return instance;
	}
}
