package com.jone.service;

import com.jone.model.EmailDetails;

public interface EmailService {

	 String sendSimpleMail(EmailDetails details);
	 String sendMailWithAttachment(EmailDetails details);
}
