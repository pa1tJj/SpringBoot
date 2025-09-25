package com.example.demo.creational.singleton;

public class Eager {
	private static final Eager INSTANCE = new Eager();

    public Eager () {
		
	}
    
    public static Eager getInstance() {
    	return INSTANCE;
    }

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
    
    
}
