package com.jone.heath.bmi.core;

public class BmiCalculator {

	public double getBmi(double weight, double height) {
		return weight / (height * height);
	}
}
