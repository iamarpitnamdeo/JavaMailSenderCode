package com.example.MailSender;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String toEmail,
			String subject,
			String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("namdevarpit72@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("Mail sent successfully...");
	}
	public void sendEmailWithAttachments(
			String toEmail,String subject, String body,String attachment) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper mineMessageHelper = new MimeMessageHelper(message,true);
	mineMessageHelper.setFrom("namdevarpit72@gmail.com");
	mineMessageHelper.setTo(toEmail);
	mineMessageHelper.setText(body);
	mineMessageHelper.setSubject(subject);
	FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
	mineMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
	mailSender.send(message);
	System.out.println("Email Send");
	}
	
}
