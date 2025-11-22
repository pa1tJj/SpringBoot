package com.jone.di_to_go.loosecoupling.di.v1constructor;

public class UserService {

	//SRP: TỚ GIỎI VỤ CRUD TABLE ACCOUNT, TRONG RAM
	// TỚ CẦN 2 DEPENDENCY, MỖI THẰNG LO 1 VIỆC: USER-REPO VÀ EMAIL-SENDER
	private UserRepository userRepository;// có new hay không, có là tight coupling
	//lỏng ra, đó là DI, nghĩa là không full control - @Autowired là DI
	
	//private EmailSender emailSender = new EmailSender(): full Control, không DI 
	//@Autowired: AI ĐÓ KHÁC NEW VÀ TIÊM CHÍCH OBJECT VÀO CHO MÌNH SERVICE 
	//SPRING /SPRING BOOT LÀM GIÚP VIỆC NEW CHÍCH/TIÊM
	private EmailSender emailSender; // KHÔNG NEW THÌ PHẢI ĐƯỢC ĐƯA VÀO 
	
	//CÓ NHIỀU CÁCH OBJ TỪ NGOÀI VÀO TRONG CLASS
	// 1.TRỰC TIẾP QUA FIELD, BIẾN emailSender thành PUBLIC - NGUY HIỂM VI PHẠM ENCAPSULATION -> VẪN MUỐN QUA FIELD MÀ PRIVATE-DÙNG KỸ THUẬT NÂNG CAO REFLECTION
	// FIELD INJECTION (DÙNG REFLECTION, IOC FRAMEWORK)
	
	// 2. TRUYỀN QUA CONSTRUCTOR - CÁCH MLEM NHẤT
	// TẠO OBJECT QUA CONSTRUCTOR VÀ NHẬN THÊM ĐỒ QUA THAM SỐ CONSTRUCTOR
	// OBJECT DEPENDENCY ĐI QUA, ĐƯA QUA CONSTRUCTOR
	
	// 3. SETTER - TRUYỀN QUA HÀM SET() NHƯNG NẾU KHÔNG GỌI SET() THÌ DEPENDENCY BỊ NULL
	
	// 4. DÙNG FRAMEWORK/THƯ VIỆN BÊN NGOÀI TƯ KIỂM SOÁT VIỆC TẠO OBJECT DEPENDENCY VÀ TIÊM CHÍCH VÀO: SPRING/SPRINGBOOT

    public UserService(UserRepository userRepository, EmailSender emailSender) {
    	this.userRepository = userRepository;
    	this.emailSender = emailSender;
    }
    
    public UserService(EmailSender emailSender) {
    	this.emailSender = emailSender;
    }

    public void registerAccount(Account account) {
    	//TODO: DÙNG REPO XUỐNG TABLE
    	//GỬI MAIL
    	emailSender.sendEmail("phan@gmail.com", "please input the OTP...");
    }
}
