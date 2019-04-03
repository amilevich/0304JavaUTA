package com.ers.controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;

import com.ers.dao.UserDaoImpl;
import com.ers.model.User;

public class LoginController {
	public static String Login(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.selectUserByUsername(name);
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(name.getBytes(StandardCharsets.UTF_8)); 		// 'salt' with username
		byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));	// hash pw
		String shaPassword = String.format("%064x", new BigInteger(1, digest));

		if (name.equals(user.getUsername()) && shaPassword.equals(user.getPassword())) {

			request.getSession().setAttribute("User", user); // used in order to know who is logged in
			System.out.println("User set ready to load");
			return "/HTML/Home.html";
		}
		return "/HTML/Login.html";
	}
	
	public static String Logout(HttpServletRequest request)
	{
		request.getSession().setAttribute("User", null);
		return "/HTML/Login.html";
	}
}
