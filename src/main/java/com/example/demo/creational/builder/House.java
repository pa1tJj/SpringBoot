package com.example.demo.creational.builder;

import lombok.Data;

@Data
public class House {
	private String foundation;
	private String walls;
	private String roof;
	private String interior;

	public static class HouseBuider {
		private String foundation;
		private String walls;
		private String roof;
		private String interior;
		
		public HouseBuider setFoundation(String foundation) {
			this.foundation = foundation;
			return this;
		}
		
		public HouseBuider setWalls(String walls) {
			this.walls = walls;
			return this;
		}
		
		public HouseBuider setRoof(String roof) {
			this.roof = roof;
			return this;
		}
		
		public HouseBuider setInterior(String interior) {
			this.interior = interior;
			return this;
		}
		
		public House getResult() {
			return new House(this);
		}
	}
	
	private House (HouseBuider houseBuider) {
		this.foundation = houseBuider.foundation;
		this.interior = houseBuider.interior;
		this.roof = houseBuider.roof;
		this.walls = houseBuider.walls;
	}
}


