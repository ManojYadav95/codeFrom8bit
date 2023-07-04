package com.SpringMailSender;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SenderMail {

	@Autowired
	private JavaMailSender senderEmail;

	public void senderMail(String toMail, String subject, String message, String attachment) throws MessagingException {
		
		MimeMessage mimeMessage = senderEmail.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setFrom("mkroks21my15@gmail.com");
		mimeMessageHelper.setTo(toMail);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(message);
		
		FileSystemResource fileSystemResourse = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(fileSystemResourse.getFilename(), fileSystemResourse);
		senderEmail.send(mimeMessage);

		System.out.println("Mail Sent successfully");

	}
}
