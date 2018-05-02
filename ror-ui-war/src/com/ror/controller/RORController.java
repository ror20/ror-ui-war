package com.ror.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ror.model.RORUser;
import com.ror.svc.RORSvc;

@Controller
public class RORController {

	private static final String ROR_USER_ID = "rorUserId";

	private static final String ROR_USER_PASSWORD = "rorUserPassword";

	private static final String PROFILE_PAGE = "jsp/profile";

	private static final String USER_NAME = "rorUserName";

	private static final String LOGIN_PAGE = "index";

	private static final String LOGIN_MESSAGE = "loginMessage";

	private static final String LOGIN_INVALID = "Invalid User Id/Password";

	@Autowired
	private RORSvc rorSvc;

	@RequestMapping("/main")
	public ModelAndView sampleControllerCheck(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("index", "status", "Controller hit Success!!");
	}

	@RequestMapping("/authenticate")
	public ModelAndView authenticateUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String rorUserId = request.getParameter(ROR_USER_ID);
		String rorUserPassword = request.getParameter(ROR_USER_PASSWORD);
		RORUser user = new RORUser(null, rorUserId, null, rorUserPassword);
		if ((user = rorSvc.authenticateUser(user)) != null) {
			mav = new ModelAndView(PROFILE_PAGE, USER_NAME, user.getUserName());
		} else {
			mav = new ModelAndView(LOGIN_PAGE, LOGIN_MESSAGE, LOGIN_INVALID);
		}
		return mav;
	}

}
