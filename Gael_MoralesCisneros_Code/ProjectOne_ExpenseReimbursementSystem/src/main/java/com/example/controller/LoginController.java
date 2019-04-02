package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.example.servlet.MasterServlet;
import com.projectone.dao.UserRolesDaoImpl;
import com.projectone.dao.UsersDaoImpl;
import com.projectone.models.UserRoles;
import com.projectone.models.Users;

public class LoginController {
	
	public static String Login(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
    System.out.println(username + " "+ password);
		UsersDaoImpl udi = new UsersDaoImpl();
		Users user = new Users();
    
		user = udi.selectUserByName(username, password);
		if(user == null) {
			MasterServlet.logger.info("failed login: "+username);
			return "/html/Index.html";
		}
   System.out.println("user: "+user);
		if(username.equals(user.getErsUsername()) && password.equals(user.getErsPassword())) {
			request.getSession().setAttribute("User", user);
			Integer roleId = user.getUserRoleId();
			UserRoles ur = new UserRoles();
			UserRolesDaoImpl urdi = new UserRolesDaoImpl();
			ur = urdi.selectUserRolesByName(roleId);
			System.out.println("user role: "+ur);
			if(ur.getUserRole().equals("Viking")) {
				MasterServlet.logger.info("employee login: "+user.getErsUsername());
				return "/html/EmployeePortal.html";
			} else if(ur.getUserRole().equals("fm")){
				MasterServlet.logger.info("fManager login: "+user.getErsUsername());
				return "/html/FManagerPortal.html";
			}
		}
		return "/html/Index.html";
	}
}
