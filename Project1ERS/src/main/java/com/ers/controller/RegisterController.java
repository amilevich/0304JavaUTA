package com.ers.controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

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
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(name.getBytes(StandardCharsets.UTF_8)); 		// 'salt' with username
		byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));	// hash pw
		String shaPassword = String.format("%064x", new BigInteger(1, digest));
		
		User user = new User(name, shaPassword, "Employee");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(user);
		
		return "/HTML/Login.html";
	}
}
