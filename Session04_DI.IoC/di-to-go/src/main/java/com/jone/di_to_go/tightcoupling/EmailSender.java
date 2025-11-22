package com.jone.di_to_go.tightcoupling;

public class EmailSender {

	// CLASS NÀY CHUYÊN GỬI EMAIL, KHÔNG DÍNH GÌ ĐẾN SMS, KHÔNG DÍNH ĐẾN WHATSAPP, THỎA MÃN NGUYÊN LÍ S/SRP TRONG SOLID
	//CHỈ CHƯA HÀM, NHIỀU HÀM CHUYÊN LIÊN QUAN EMAIL - 1 CHỦ THỂ
	// SAU NÀY NÂNG CẤP CODE, CŨNG CHỈ LÀ XOAY QUANH EMAIL
	
	public void sendEmail(String recipient, String message) {
		//LOGIC XỬ LÍ GỬI EMAIL
		System.out.println("mail was sent to:" + recipient + "successfully!" + message);
	}
}
