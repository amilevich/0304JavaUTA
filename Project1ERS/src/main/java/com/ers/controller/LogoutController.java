package com.ers.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public class LogoutController {
	
	final static Logger logger = Logger.getLogger(HomeController.class.getName());

	public static String Logout(HttpServletRequest request) {
		logger.info("USER LOGGED OUT");
		request.getSession().setAttribute("User", null);
		return "/HTML/Login.html";
	}
}
