package com.example.demo.creational.singleton;

public class BillPugh {
	private BillPugh() {}
	
	private static class SingletonHelper {
		private static BillPugh INSTANCE = new BillPugh();
	}

	public static BillPugh getInstance()  {
		return SingletonHelper.INSTANCE;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
