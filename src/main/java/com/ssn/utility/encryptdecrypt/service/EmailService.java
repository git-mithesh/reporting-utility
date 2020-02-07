package com.ssn.utility.encryptdecrypt.service;


	import java.io.File;

import javax.mail.MessagingException;
	import javax.mail.internet.MimeMessage;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
	import org.springframework.mail.MailException;
	import org.springframework.mail.SimpleMailMessage;
	import org.springframework.mail.javamail.JavaMailSender;
	import org.springframework.mail.javamail.MimeMessageHelper;
	import org.springframework.stereotype.Service;

import com.ssn.utility.encryptdecrypt.beans.User;

	@Service
	public class EmailService {

		/*
		 * The Spring Framework provides an easy abstraction for sending email by using
		 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
		 * it as well as a starter module.
		 */
		private JavaMailSender javaMailSender;

		/**
		 * 
		 * @param javaMailSender
		 */
		@Autowired
		public EmailService(JavaMailSender javaMailSender) {
			this.javaMailSender = javaMailSender;
		}

		/**
		 * This function is used to send mail without attachment.
		 * @param user
		 * @throws MailException
		 */

		public void sendEmail(User user) throws MailException {

			/*
			 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
			 * JavaMailSender extends the MailSender Interface which contains send()
			 * function. SimpleMailMessage Object is required because send() function uses
			 * object of SimpleMailMessage as a Parameter
			 */

			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(user.getEmail());
			mail.setSubject("Testing Mail API");
			mail.setText("Hurray ! You have done that dude...");

			/*
			 * This send() contains an Object of SimpleMailMessage as an Parameter
			 */
			javaMailSender.send(mail);
		}

		/**
		 * This fucntion is used to send mail that contains a attachment.
		 * 
		 * @param user
		 * @throws MailException
		 * @throws MessagingException
		 */
		public void sendEmailWithAttachment(User user) throws MailException, MessagingException {

			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			helper.setTo(user.getEmail());
			helper.setSubject("Testing Mail API with Attachment");
			helper.setText("Please find the attached document below.");
			String fileName="/Users/mitheshjain/Documents/"+user.getName();
            FileSystemResource res = new FileSystemResource(new File(fileName));

			helper.addAttachment("Query Ran Successfully", res);

			javaMailSender.send(mimeMessage);
		}

	}

