package com.pro.club.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.club.entities.secC.EmailDetails;
import com.pro.club.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	public EmailService emailService;
	
	@PostMapping("/sendMail")
	public String
	sendMail(@RequestBody EmailDetails details)
	{
		String status = emailService.sendSimpleMail(details);
		return status;
	}
	
	@PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody EmailDetails details)
    {
        String status
            = emailService.sendMailWithAttachment(details);
 
        return status;
    }
}
