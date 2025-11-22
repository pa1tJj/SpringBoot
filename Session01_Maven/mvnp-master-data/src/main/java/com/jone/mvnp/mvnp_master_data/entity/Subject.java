package com.jone.mvnp.mvnp_master_data.entity;

public class Subject {
	private String code;
	private String name;
	private int credits;
	private double hours;
	
	public Subject() {}

	public Subject(String code, String name, int credits, double hours) {
		super();
		this.code = code;
		this.name = name;
		this.credits = credits;
		this.hours = hours;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
	

}
