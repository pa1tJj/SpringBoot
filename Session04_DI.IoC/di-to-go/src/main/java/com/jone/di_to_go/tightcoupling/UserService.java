package com.jone.di_to_go.tightcoupling;


// CLASS CHÍNH LÀ ĐÂY
public class UserService {

	//CÓ ÍT NHẤT 2 DEPENDENCY SERVICE CẦN
	//1. USER-REPO
	//2.GỬI EMAIL/SMS.WHATSAPP CONFIRM
	private UserRepository userRepository = new UserRepository();// dependency, tight coupling, chủ động quản lí object denpendency
	private EmailSender emailSender = new EmailSender();// dependency, tight coupling, chủ động tạo object
	//hard-coded dependency
	//full control, direct-controll dependency: tự khai báo, tự new
	// vấn để: sau này thay = SMS, WhatsApp phải sửa code class chính này
	
	//có nhiều hàm liên quan đến table user: getAllAccount(), findByEmail()...
	//nhận vào full info Account từ web form đăng kí, hoặc nhận vào DTO
	//chứa email, phone, whatsapp id bên trong trích ra
	
	public void registerAccount(Account acc) {
		//TODO: gọi repo để xuống table- dùng DEPENDENCY 1
		//Gửi maiil confirm- dùng DEPENDENCY 2
		//                   acc.email
		emailSender.sendEmail("phan.@gmail.com", "please input OTP");
	}
	
}

//class A: class Service
//class B: class EmailSender - dependency của A
