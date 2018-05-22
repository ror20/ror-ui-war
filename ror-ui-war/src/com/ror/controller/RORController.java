package com.ror.controller;

import static com.ror.constants.RORConstants.APPEND_SPACE;
import static com.ror.constants.RORConstants.LOGIN_INVALID;
import static com.ror.constants.RORConstants.LOGIN_MESSAGE;
import static com.ror.constants.RORConstants.LOGIN_PAGE;
import static com.ror.constants.RORConstants.LOGOUT_MESSAGE;
import static com.ror.constants.RORConstants.PASSWORD_RESET_FAILED;
import static com.ror.constants.RORConstants.PASSWORD_RESET_PAGE;
import static com.ror.constants.RORConstants.PASSWORD_RESET_SUCCESSFULLY;
import static com.ror.constants.RORConstants.PROFILE_MESSAGE;
import static com.ror.constants.RORConstants.PROFILE_PAGE;
import static com.ror.constants.RORConstants.RESET_MESSAGE;
import static com.ror.constants.RORConstants.ROR_USER_EMAIL;
import static com.ror.constants.RORConstants.ROR_USER_ID;
import static com.ror.constants.RORConstants.ROR_USER_NAME;
import static com.ror.constants.RORConstants.ROR_USER_PASSWORD;
import static com.ror.constants.RORConstants.SESSION_INVALID_PLEASE_LOGIN_TO_CONINUE;
import static com.ror.constants.RORConstants.SIGNUP_PAGE;
import static com.ror.constants.RORConstants.SIGN_UP_FAILED;
import static com.ror.constants.RORConstants.SIGN_UP_MESSAGE;
import static com.ror.constants.RORConstants.SIGN_UP_SUCCESS;
import static com.ror.constants.RORConstants.TOKEN_MESSAGE;
import static com.ror.constants.RORConstants.TOKEN_PAGE;
import static com.ror.constants.RORConstants.UPDATED_USER_DETAILS_FAILED;
import static com.ror.constants.RORConstants.UPDATED_USER_DETAILS_SUCCESS;
import static com.ror.constants.RORConstants.UPDATE_MESSAGE;
import static com.ror.constants.RORConstants.UPDATE_USER_PAGE;
import static com.ror.constants.RORConstants.USER_DOES_NOT_EXIST;
import static com.ror.constants.RORConstants.USER_NAME;
import static com.ror.constants.RORConstants.USER_OBJECT;
import static com.ror.constants.RORConstants.USER_TOKEN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ror.model.RORUser;
import com.ror.model.RORUserToken;
import com.ror.svc.RORSvc;
import com.ror.utils.RORUtils;

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
			session.setAttribute(USER_OBJECT, user);
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
		System.out.println("Session status:"+request.getSession());
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
		String rorUserId = request.getParameter(ROR_USER_ID);
		String tokenStatus = null;
		if (rorUserId != null) {
			RORUser user = rorSvc.fetchUser(rorUserId);
			if (user != null) {
				tokenStatus = RORUtils.sendPasswordResetMail(user, rorSvc);
				System.out.println(tokenStatus);
			}else {
				return new ModelAndView(LOGIN_PAGE,LOGOUT_MESSAGE,USER_DOES_NOT_EXIST);
			}

		}
		mav = new ModelAndView(TOKEN_PAGE, TOKEN_MESSAGE, tokenStatus);
		mav.addObject(ROR_USER_ID, rorUserId);
		return mav;
	}

	@RequestMapping("/tokenCheck")
	public ModelAndView checkUserToken(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String rorUserId = request.getParameter(ROR_USER_ID);
		String rorUserToken = request.getParameter(USER_TOKEN);
		System.out.println("tokenCheck user ID is " + rorUserId);
		RORUserToken token = null;
		if (rorUserId != null) {
			token = rorSvc.fetchUserToken(rorUserId);
		}
		if (token != null) {
			if (token.getToken().equals(rorUserToken)) {
				mav = new ModelAndView(PASSWORD_RESET_PAGE, ROR_USER_ID, rorUserId);
				RORUser user = rorSvc.fetchUser(rorUserId);
				if (user != null) {
					mav.addObject(ROR_USER_NAME, user.getUserName());
				}
			} else {
				String tokenStatus = "Token Incorrect";
				mav = new ModelAndView(TOKEN_PAGE, TOKEN_MESSAGE, tokenStatus);
				mav.addObject(ROR_USER_ID, rorUserId);
			}
		} else {
			String tokenStatus = "Token Incorrect";
			mav = new ModelAndView(TOKEN_PAGE, TOKEN_MESSAGE, tokenStatus);
			mav.addObject(ROR_USER_ID, rorUserId);
		}
		return mav;
	}

	@RequestMapping("/resetPassword")
	public ModelAndView resetUserPassword(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String rorUserId = request.getParameter(ROR_USER_ID);
		String password = request.getParameter(ROR_USER_PASSWORD);
		RORUser user = rorSvc.fetchUser(rorUserId);
		if (user != null) {
			user.setPassword(password);
			boolean flag = rorSvc.updateUser(user);
			if (!flag) {
				mav = new ModelAndView(PASSWORD_RESET_PAGE, ROR_USER_ID, rorUserId);
				mav.addObject(RESET_MESSAGE, PASSWORD_RESET_FAILED);
			} else {
				mav = new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, PASSWORD_RESET_SUCCESSFULLY);
			}
		} else {
			mav = new ModelAndView(PASSWORD_RESET_PAGE, ROR_USER_ID, rorUserId);
			mav.addObject(RESET_MESSAGE, PASSWORD_RESET_FAILED);
		}
		return mav;
	}
	
	@RequestMapping("/updateProfile")
	public ModelAndView redirectingToUpdateProfile(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = null;
		HttpSession session = request.getSession();
		if(session!=null) {
			RORUser user =(RORUser)session.getAttribute(USER_OBJECT);
			if(user!=null) {
				System.out.println("Redirecting to Update Profile Page");
				mav=new ModelAndView(UPDATE_USER_PAGE);
			}else {
				System.out.println("User is Null.. Redirecting to Login page");
				mav = new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, SESSION_INVALID_PLEASE_LOGIN_TO_CONINUE);
			}
		}else {
			System.out.println("Session is Null.. Redirecting to Login page");
			mav = new ModelAndView(LOGIN_PAGE, LOGOUT_MESSAGE, SESSION_INVALID_PLEASE_LOGIN_TO_CONINUE);
		}
		return mav;
	}

	@RequestMapping("/updateUser")
	public ModelAndView updateUserRecord(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		String userName = request.getParameter(ROR_USER_NAME);
		String userId = request.getParameter(ROR_USER_ID);
		String password = request.getParameter(ROR_USER_PASSWORD);
		String emailId = request.getParameter(ROR_USER_EMAIL);
		RORUser user = (RORUser) request.getSession().getAttribute(USER_OBJECT);
		if (user == null) {
			System.out.println("User is null from session");
			mav = new ModelAndView(PROFILE_PAGE);
		} else {
			if (userName != null && emailId != null && password != null) {
				RORUser updatedUser = new RORUser(userName, userId, emailId, password);
				boolean updateStatus = rorSvc.updateUser(updatedUser);
				if (updateStatus) {
					System.out.println("Updated user successfully!");
					mav = new ModelAndView(PROFILE_PAGE, USER_NAME, updatedUser.getUserName());
					mav.addObject(PROFILE_MESSAGE,UPDATED_USER_DETAILS_SUCCESS);
					HttpSession session = request.getSession();
					session.setAttribute(USER_OBJECT, updatedUser);
				}else {
					System.out.println("Updated user Failed!");
					mav = new ModelAndView(UPDATE_USER_PAGE, UPDATE_MESSAGE,UPDATED_USER_DETAILS_FAILED );
				}
				
			}else {
				System.out.println("Updated user Failed!");
				mav = new ModelAndView(UPDATE_USER_PAGE, UPDATE_MESSAGE,UPDATED_USER_DETAILS_FAILED );
			}
		}
		return mav;
	}

}
