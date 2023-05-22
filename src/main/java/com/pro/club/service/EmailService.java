package com.pro.club.service;

import com.pro.club.entities.secC.EmailDetails;

public interface EmailService {

	 String sendSimpleMail(EmailDetails details);
	 
	 String sendMailWithAttachment(EmailDetails details);
}
