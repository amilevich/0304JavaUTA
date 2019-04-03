package com.Project1.controller;

import javax.servlet.http.HttpServletRequest;

import com.Project1.DaoImpl.UserDaoImpl;
import com.Project1.Model.User;

public class RegisterController {
	
	public static String Register(HttpServletRequest request){
	    String Fname = request.getParameter("FName");
	    String Lname = request.getParameter("LName");
	    String Email = request.getParameter("Email");
	    String Uname = request.getParameter("Uname");
	    String Pass = request.getParameter("Pass");
	    
	    User user = new User();
	    user.setFirstName(Fname);
	    user.setLastName(Lname);
	    user.setEmail(Email);
	    user.setUsername(Uname);
	    user.setPassword(Pass);
	    user.setRoleId(0);
	    
	    UserDaoImpl userDI = new UserDaoImpl();
	    user.setUserId(Math.max(userDI.returnMaxUserId(),0)+1);
	    userDI.insertUser(user); 
	    
	    
	    return "/html/Login.html";
	    }
}
