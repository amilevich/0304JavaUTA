package com.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.ers.dao.UserDaoImpl;
import com.ers.model.User;

public class RegisterController {
	
	public static String Register(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("In RegisterController.Register");
		System.out.println(name);
		System.out.println(password);
		
		User user = new User(name, password, "Employee");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(user);
		
		return "/HTML/Login.html";
	}
}
