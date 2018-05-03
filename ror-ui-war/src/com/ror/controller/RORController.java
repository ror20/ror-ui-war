package com.ror.controller;

import static com.ror.constants.RORConstants.APPEND_SPACE;
import static com.ror.constants.RORConstants.LOGIN_INVALID;
import static com.ror.constants.RORConstants.LOGIN_MESSAGE;
import static com.ror.constants.RORConstants.LOGIN_PAGE;
import static com.ror.constants.RORConstants.LOGOUT_MESSAGE;
import static com.ror.constants.RORConstants.PROFILE_PAGE;
import static com.ror.constants.RORConstants.ROR_USER_ID;
import static com.ror.constants.RORConstants.ROR_USER_NAME;
import static com.ror.constants.RORConstants.ROR_USER_PASSWORD;
import static com.ror.constants.RORConstants.SIGNUP_PAGE;
import static com.ror.constants.RORConstants.USER_NAME;

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

}
