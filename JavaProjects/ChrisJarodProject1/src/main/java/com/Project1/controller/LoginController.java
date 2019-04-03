package com.Project1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project1.DaoImpl.UserDaoImpl;
import com.Project1.Model.User;

public class LoginController {

	public static String Login(HttpServletRequest request, HttpServletResponse response) {

		String Uname = request.getParameter("Uname");
		String Pass = request.getParameter("Pass");
		UserDaoImpl userDI = new UserDaoImpl();
		User user = new User();

		user = userDI.selectUserByUsername(Uname);

		String resp = "Login.html?LoginFailed";
		try {
			PrintWriter output = response.getWriter();
			response.setHeader("Content-Type", "text/plain");
			if (user == null)
			{
				output.write(resp);
				return "Login.html";	
			}
			else
			if (Uname.equals(user.getUsername()) && Pass.equals(user.getPassword())) {
				request.getSession().setAttribute("User", user);
				if(user.getRoleId() == 0) {
					output.write("EHome.html");
					return "EHome.html";
				}
				else {
					output.write("FHome.html");
					return "FHome.html";
				}
				
			}
			output.write(resp);
			return "Login.html";
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resp;
	}

}
