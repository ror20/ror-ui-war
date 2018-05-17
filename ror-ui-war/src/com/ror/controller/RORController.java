package com.ror.controller;

import static com.ror.constants.RORConstants.APPEND_SPACE;
import static com.ror.constants.RORConstants.LOGIN_INVALID;
import static com.ror.constants.RORConstants.LOGIN_MESSAGE;
import static com.ror.constants.RORConstants.LOGIN_PAGE;
import static com.ror.constants.RORConstants.LOGOUT_MESSAGE;
import static com.ror.constants.RORConstants.PROFILE_PAGE;
import static com.ror.constants.RORConstants.ROR_USER_EMAIL;
import static com.ror.constants.RORConstants.ROR_USER_ID;
import static com.ror.constants.RORConstants.ROR_USER_NAME;
import static com.ror.constants.RORConstants.ROR_USER_PASSWORD;
import static com.ror.constants.RORConstants.SIGNUP_PAGE;
import static com.ror.constants.RORConstants.SIGN_UP_FAILED;
import static com.ror.constants.RORConstants.SIGN_UP_MESSAGE;
import static com.ror.constants.RORConstants.SIGN_UP_SUCCESS;
import static com.ror.constants.RORConstants.USER_NAME;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ror.model.RORUser;
import com.ror.svc.RORSvc;

@Controller
public class RORController {

	@Autowired
	private RORSvc rorSvc;

	@RequestMapping("/authenticate")
	public ModelAndView authenticateUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String rorUserId = request.getParameter(ROR_USER_ID);
		String rorUserPassword = request.getParameter(ROR_USER_PASSWORD);
		RORUser user = new RORUser(null, rorUserId, null, rorUserPassword);
		if ((user = rorSvc.authenticateUser(user)) != null) {
			HttpSession session = request.getSession();
			session.setAttribute(ROR_USER_NAME, user.getUserName());
			mav = new ModelAndView(PROFILE_PAGE, USER_NAME, user.getUserName());
		} else {
			mav = new ModelAndView(LOGIN_PAGE, LOGIN_MESSAGE, LOGIN_INVALID);
		}
		return mav;
	}

	@RequestMapping("/signup")
	public ModelAndView signUpPageRedirection(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView(SIGNUP_PAGE);
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		String message = "Thank You For visiting";
		System.out.println("Session name: " + request.getSession().getAttribute(ROR_USER_NAME));
		if (request.getSession().getAttribute(ROR_USER_NAME) != null) {
			String userName = (String) request.getSession().getAttribute(ROR_USER_NAME);
			request.getSession().invalidate();
			return new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, message + APPEND_SPACE + userName + "!");
		}
		return new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, message + "!");
	}

	@RequestMapping("/storeUser")
	public ModelAndView storeUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String userName = request.getParameter(ROR_USER_NAME);
		String userId = request.getParameter(ROR_USER_ID);
		String password = request.getParameter(ROR_USER_PASSWORD);
		String emailId = request.getParameter(ROR_USER_EMAIL);
		RORUser newUser = new RORUser(userName, userId, emailId, password);
		boolean storeStatus = rorSvc.storeUser(newUser);
		if (!storeStatus) {
			mav = new ModelAndView(SIGNUP_PAGE, SIGN_UP_MESSAGE, SIGN_UP_FAILED);
			mav.addObject(ROR_USER_NAME, userName);
			mav.addObject(ROR_USER_ID, userId);
			mav.addObject(ROR_USER_EMAIL, emailId);
		} else {
			mav = new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, SIGN_UP_SUCCESS);
		}
		return mav;
	}

	@RequestMapping("/forgotPassword")
	public ModelAndView forgotPassword(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String to = "sudarsansolai@gmail.com";
		String from = "susasan27@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.user", "susasan27@gmail.com");
		properties.setProperty("mail.password", "sheissosweethotcutee");
		Session session = Session.getDefaultInstance(properties);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("This is the Subject Line!");
			message.setText("This is actual message");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		mav = new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, "Instruction sent to mail");
		return mav;
	}
	
}
