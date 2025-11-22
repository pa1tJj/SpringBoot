package com.jone.di_to_go.loosecoupling.di.v2setter;
// GUI --- CONTROLLER --- SERVICE --- REPO (JPA/HIBERNATE CRUD) --- TABLE
public class UserService {
	//CHUYÊN XỬ LÍ DATA VỀ USER/ACCOUMT TRONG RAM, SAU ĐÓ GỌI REPO ĐỂ XUỐNG TABLE
	//TA CẦN TRỢ GIÚP TỪ NGOÀI 2 VIỆC/2 DEPENDENCY: REPO, SENDER GỬI CONFIRM
	//TA KHÔNG TỰ NEW, KHÔNG NUÔI 2 THẰNG NÀY, BÊN NGOÀI TIÊM CHÍCH VÀO, GỌI DỊCH VỤ
	//C1: FIELD
	//C2: CONSTRUCTOR ĐÃ LÀM
	//C3: SETTER
	//C4: DÙNG FRAMEWORK
	private UserRepository userRepository;//không new chờ tiêm vào
	private EmailSender emailSender;//không new chờ tiêm vào
	//setter tự generate hoặc tự gõ code - y chang yob, gpa được set
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}
	
	//CÁCH NÀY DỄ HIỂU NHƯNG PHẢI TRẢ GIÁ: NULL CHO DEPENDENCY SET()
	//NẾU CONSTRUCTOR, BẠN KHÔNG ĐƯA VÀO CONSTRUCTOR, THÌ KHÔNG NEW ĐƯỢC, VÌ CONSTRUCTOR YÊU CẦU PHẢI ĐƯA THAM SỐ VÀO THÌ MỚI
	//CHỌN VẸN VIỆC GỌI HÀM
	
	
	public void registerAccount(Account account) {
		//TODO: logic code gọi CRUD
		emailSender.sendEmail("phan@gmail.com", "pls check OTP");
	}
}
