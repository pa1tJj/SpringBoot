package com.jone.di_to_go.loosecoupling.di.v3finalfantasy;

// LÀM CHUYỆN GIỎI NHẤT:  ĐÓ LÀ TÔI GIỎI GỬI SMS
public class SmsSender implements NotiService{
	public void sendSms(String phone, String message) {
		//TODO: logic xử lý gửi SMS
		
		//thông báo thành công
		System.out.println("(DI - V3 - OCP): SMS was sent to " + phone + " succesfully!\n" + message);
	}

	@Override
	public void sendNoti(String to, String message) {
		// TODO Auto-generated method stub
		sendSms(to, message);
	}

	
}
