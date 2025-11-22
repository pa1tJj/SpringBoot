package com.jone.di_to_go.tightcoupling;

public class MainTightCoupling {

	public static void main(String[] args) {
		//CLASS NÀY ĐÓNG VAI UI, CONTROLLER, GỌI ĐIỀU KHIỂN NHỮNG CLASS Ở TẦNG DƯỚI: SERVICE, REPO...
		UserService userService = new UserService();
		userService.registerAccount(new Account());
	}
}
