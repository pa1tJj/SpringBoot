package com.example.demo.creational.abstract_factory;

interface CarFactory {
	Car createCar();
	CarSpecification carSpecification();
}

interface Car {
	void assemble();
}

interface CarSpecification {
	void display();
}

class Sedan implements Car {

	@Override
	public void assemble() {
		System.out.println("lắp ráp xe Sedan");
	}
}

class HatchBack implements Car {

	@Override
	public void assemble() {
		System.out.println("lắp ráp xe HatchBack");
	}	
}

class NASpecification implements CarSpecification {

	@Override
	public void display() {
		System.out.println("Đặc điểm kỹ thuật xe Bắc Mỹ: tuân thủ các tính năng an toàn");		
	}
}

class EuropeSpecification implements CarSpecification {

	@Override
	public void display() {
		System.out.println("Thông số xe châu Âu: Hiệu quả nhiên liệu và khí thải tuân thủ theo tiêu chuẩn EU");		
	}	
}
class NACarFactory implements CarFactory {

	@Override
	public Car createCar() {
		return new Sedan();
	}

	@Override
	public CarSpecification carSpecification() {
		return new NASpecification();
	}
}

class EuropeCarFactory implements CarFactory {

	@Override
	public Car createCar() {
		return new HatchBack();
	}

	@Override
	public CarSpecification carSpecification() {
		return new EuropeSpecification();
	}	
}

public class AbstractFactory {
	public static void main(String[] args) {
		//tạo một chiếc xe ở NA
		CarFactory carFactory = new NACarFactory();
		Car car = carFactory.createCar();
		CarSpecification carSpecification = carFactory.carSpecification();
		car.assemble();
		carSpecification.display();
	}
}
