package com.jone.di_to_go.loosecoupling.di.v1constructor;

//SRP THỎA
public class EmailSender {

	public void sendEmail(String recipient, String message) {
		// LOGIC XỬ LÍ GỬI EMAIL
		System.out.println("(DI) mail was sent to:" + recipient + "successfully!" + message);
	}
}
