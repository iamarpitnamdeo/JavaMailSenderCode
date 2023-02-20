package com.example.MailSender;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderApplication {
	@Autowired
	private EmailSenderService emailSendService;
	public static void main(String[] args) {
		SpringApplication.run(MailSenderApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws MessagingException {
		emailSendService.sendEmail("narpit2@gmail.com",
				"Subject of the email", "This is the body of the email");
		emailSendService.sendEmailWithAttachments("narpit2@gmail.com", 
"This is mail body ", "This mail has attachment", 
"/Users/arpitnamdeo/Downloads/Arpit_Rsume_2.5Y_Exp.pdf");
	}
}
