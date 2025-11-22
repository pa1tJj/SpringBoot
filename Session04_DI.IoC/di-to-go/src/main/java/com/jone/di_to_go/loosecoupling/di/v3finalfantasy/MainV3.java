package com.jone.di_to_go.loosecoupling.di.v3finalfantasy;

public class MainV3 {
	public static void main(String[] args) {
		//gửi mail confirm khi đăng kí
		EmailSender emailSender = new EmailSender();
		//DÙNG SERVICE
		UserService userService = new UserService(emailSender);//tiêm emailSender vào UserService thông qua Constructor
		userService.registerAccount("phan@gmail.com", "pls via OTP");
		
		System.out.println("\nWITH SMS");
		SmsSender smsSender = new SmsSender();
		UserService userServiceSMS = new UserService();
		userServiceSMS.setNoti(smsSender);
		userServiceSMS.registerAccount("091493274", "pls via OTP");
	
	    //Gửi WhatsApp
		WhatsAppSender whatsAppSender = new WhatsAppSender();
		//KHÔNG THÈM SỬA SERVICE, CHƠI VỚI TƯƠNG LAI NotiService
		userServiceSMS.setNoti(whatsAppSender);
		userServiceSMS.registerAccount("+2348012345678", "OTP: 33046");
		
		//GỬI TIN NHẮN QUA TELE, DISCORD, INSTA...
		//LẼ THƯỜNG PHẢI CODE THÊM CLASS LẺ VÀ IMPLEMENT NotiService
		//KHÔNG - LÀM THEO CÁCH PRO: ANONYMOUS CLASS
		//NEW LUÔN INTERFACE
		NotiService tele = new NotiService() {
			
			@Override
			public void sendNoti(String to, String message) {
				// TODO Auto-generated method stub
				System.out.println("ANONYMOUS CLASS, DI, OCP:" + to + "; Message:" + message);
			}
		};
		
		userServiceSMS.setNoti(tele);
		userServiceSMS.registerAccount("noti TELE", "DI ĐỈNH VAILON");
	}
}
