package com.ror.utils;

import static com.ror.constants.RORConstants.ADMIN_EMAIL;
import static com.ror.constants.RORConstants.ADMIN_EMAIL_PASSWORD;
import static com.ror.constants.RORConstants.EMAIL_SUBJECT;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.gson.Gson;
import com.ror.model.RORUser;
import com.ror.model.RORUserToken;
import com.ror.svc.RORSvc;

public final class RORUtils {

	public static final String convertToJson(Object object) {
		return new Gson().toJson(object);
	}

	public static final Object convertToPOJO(Object key, Class<?> classObject) {
		return new Gson().fromJson((String) key, classObject);
	}

	public static String sendPasswordResetMail(RORUser user, RORSvc rorSvc) {
		String to = user.getEmailId();
		/*Properties properties = System.getProperties();
		properties.setProperty(MAIL_SMTP_HOST, ASPMX_L_GOOGLE_COM); // properties.setProperty("mail.smtp.port", "465");
		properties.setProperty(MAIL_USER, ADMIN_EMAIL);
		properties.setProperty(MAIL_PASSWORD, ADMIN_EMAIL_PASSWORD);
		Session session = Session.getDefaultInstance(properties);*/
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(ADMIN_EMAIL,ADMIN_EMAIL_PASSWORD);
				}
			});

		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ADMIN_EMAIL));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(EMAIL_SUBJECT);
			RORUserToken token = generatePasswordResetToken(user, rorSvc);
			if (token != null) {
				message.setText("Hello " + user.getUserName() + "." + "\nYour Security token is " + token.getToken());
				Transport.send(message);
				System.out.println("Sent message successfully....");
			} else {
				return "Failed to generate User token";
			}
		} catch (MessagingException mex) {
			mex.printStackTrace();
			rorSvc.deleteUserToken(user.getUserId());
			return "Failed to generate User token";
		}
		return "User token generated successfully";
	}

	private static RORUserToken generatePasswordResetToken(RORUser user, RORSvc rorSvc) {
		Random r = new Random();
		int number = r.nextInt(100000 - 10000) + 10000;
		String token = number + "ror";
		RORUserToken rorUserToken = new RORUserToken(token, new Date());
		boolean flag = rorSvc.storeUserToken(user, rorUserToken);
		if (flag)
			return rorUserToken;
		else {
			return null;
		}
	}

}
