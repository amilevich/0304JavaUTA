package com.ers.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.ers.dao.UserDaoImpl;
import com.ers.model.User;

public class RegisterController {
	
	final static Logger logger = Logger.getLogger(HomeController.class.getName());
	
	public static String Register(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		logger.info("REGISTRATION REQUESTED for " + name);
		
		System.out.println("In RegisterController.Register");
		System.out.println(name);
		System.out.println(password);
		
		User user = new User(name, password, "Employee");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(user);
		
		logger.info(name + " successfully registered");
		return "/HTML/Login.html";
	}
}
