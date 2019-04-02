package com.project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.project1.dao.DaoUsersImpl;
import com.project1.model.Users;
import com.project1.controller.AWSHelper;

public class RegisterController {
	
	public static String Register(HttpServletRequest request) {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DaoUsersImpl daoUsersImpl = new DaoUsersImpl();
		Users user = new Users();
		
		user.setUserFirstname(firstname);
		user.setUserLastname(lastname);
		user.setUserEmail(email);
		user.setErsUsername(username);
		user.setErsPassword(password);

		int userId = daoUsersImpl.insertUser(user);

		AWSHelper.sendMail();
		//request.getSession().setAttribute("User", user);
		// check for invalid registry
		return "Login.html";

	}
	
	public static String Update(HttpServletRequest request) {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		DaoUsersImpl daoUsersImpl = new DaoUsersImpl();
		Users user = new Users();
		
		user.setUserFirstname(firstname);
		user.setUserLastname(lastname);
		user.setUserEmail(email);
		user.setErsUsername(username);
		user.setErsPassword(password);
		user.setErsUsersId(userId);

		int updatedUserId = daoUsersImpl.updateUser(user);

		return "Login.html";

	}
}
