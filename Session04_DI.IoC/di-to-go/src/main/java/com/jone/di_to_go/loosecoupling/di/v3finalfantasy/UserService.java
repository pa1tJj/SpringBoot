package com.jone.di_to_go.loosecoupling.di.v3finalfantasy;

public class UserService {
	public UserService() {}

	//private SmsSender smsSender;//không new chờ tiêm/chích vào
	//private EmailSender emailSender;// không new chở tiêm/chích vào
	private UserRepository userRepository;// không new chờ tiêm/chích vào
	
	//KHAI BÁO SmsSender, EmailSender đang gọi là khai báo cứng dependency không tốt cho tương lai khi cần thêm phương thức WHATSAPP
	// không nên phụ thuộc vào cái cụ thể như trên, ta nên phụ thuộc vào cái chung chung để sau này còn dễ bổ sung các hình thức gửi 
	// khác mà không thèm sửa code của chính class SERVICE này
	
	private NotiService notiService;// không new chờ tiêm/chích vào - nói chung chung là phụ thuộc vào cái đám gửi info nhưng k nói đứa nào, SMS hay Email hay...
	//NHƯNG CHẮC CHẮN 1 ĐIỀU, OBJECT NOTI CÓ HÀM sendNoti(), code như nào tính sau
	//chích vào qua field, constructor, setter, tùy chọn...
	
	public UserService(NotiService notiService) {
		this.notiService = notiService;
	}//TIÊM TỪ NGOÀI VÀO
	
	//TIÊM TỪ NGOÀI VÀO BẰNG SETTER
	public void setNoti(NotiService notiService) {
		this.notiService = notiService;
	}
	public void registerAccount(Account account) {
		//LOGIC CODE ĐỂ GỌI REPO ĐỂ CRUD TABLE ACCOUNT
		
		//Gửi noti
		//notiService.sendNoti();
	}
	
	public void registerAccount(String to, String message) {
		//LOGIC CODE ĐỂ GỌI REPO ĐỂ CRUD TABLE ACCOUNT
		
		//Gửi noti
		notiService.sendNoti(to, message);
	}
}
