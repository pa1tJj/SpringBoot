package com.example.demo.creational.singleton;

public class Test {
	
	String name;
	public void getName() {
		BillPugh billPugh = BillPugh.getInstance();
		billPugh.setName("jone");
		name = billPugh.getName();
		System.out.print(name);
	}

}
