package com.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.ers.dao.UserDaoImpl;
import com.ers.model.User;

public class LoginController {
	public static String Login(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		User user = userDaoImpl.selectUserByUsername(name);

		if (name.equals(user.getUsername()) && password.equals(user.getPassword())) {

			request.getSession().setAttribute("User", user); // used in order to know who is logged in
			return "/HTML/Home.html";
		}
		return "/HTML/Login.html";
	}
}
