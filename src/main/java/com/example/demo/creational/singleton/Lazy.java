package com.example.demo.creational.singleton;

public class Lazy {
	private static Lazy INSTANCE;
	
	private Lazy() {
		
	}
	
	public static Lazy getInstance() {
		if(INSTANCE == null) 
			INSTANCE = new Lazy();
		return INSTANCE;
	}
	
}
