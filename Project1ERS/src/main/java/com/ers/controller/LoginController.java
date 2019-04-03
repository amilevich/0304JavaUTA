package com.ers.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.ers.dao.UserDaoImpl;
import com.ers.model.User;

public class LoginController {

	final static Logger logger = Logger.getLogger(HomeController.class.getName());

	public static String Login(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		logger.info("LOGIN requested for user " + name);

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		User user = userDaoImpl.selectUserByUsername(name);

		if (user != null) {
			if (name.equals(user.getUsername()) && password.equals(user.getPassword())) {

				request.getSession().setAttribute("User", user); // used in order to know who is logged in
				logger.info(name + " LOGGED IN");
				System.out.println("User set ready to load");
				return "/HTML/Home.html";
			}
		}
		return "/HTML/Login.html";

	}
}
