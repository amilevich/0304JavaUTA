package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {

		switch(request.getRequestURI()) {
		
		case "/Project1ERS/HTML/Login.do":
			return LoginController.Login(request);
		
		case "/Project1ERS/HTML/Home.do":
			return HomeController.Home(request);
			
		case "/Project1ERS/HTML/Register.do":
			return RegisterController.Register(request);
			
		case "/Project1ERS/HTML/TicketJSON.do":
			return HomeController.UserJSON(request, response);
		
		default:
			return "/HTML/Login.html";
		}
	}
	
}
