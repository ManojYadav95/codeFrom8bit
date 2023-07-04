package com.SpringMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SpringEmailSenderApplication {

	@Autowired
	private SenderMail sendMail;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailSenderApplication.class, args);
	}
	
	String toMail = "uditp2000@gmail.com";
	String message = "Dear Sir/Ma'am,\n"+"Please do not reply of this mail. It is a system generated testing purpose mail.\n Thank you";
	String subject = "Tesing purpose mail";
	String attachment = "C:\\Users\\jagdi\\Downloads\\a.png";
	

	@EventListener(ApplicationReadyEvent.class)
	public void mailsend() throws MessagingException {
		sendMail.senderMail(toMail, subject, message,attachment);
	}
}
