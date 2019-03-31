package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("In RequestHelper.process");
		System.out.println(request.getRequestURL());
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		
		case "/Project1ERS/HTML/Login.do":
			return LoginController.Login(request);
		
		case "/Project1ERS/HTML/Home.do":
			return HomeController.Home(request);
			
		case "/Project1ERS/HTML/Register.do":
			return RegisterController.Register(request);
			
		case "/Project1ERS/HTML/TicketJSON.do":
			return HomeController.TicketJSON(request, response);
			
		case "/Project1ERS/HTML/Submit.do":
			return SubmitController.Submit(request);
			
		case "/Project1ERS/HTML/Logout.do":
			return LoginController.Logout(request);
		
		default:
			return "/HTML/Login.html";
		}
	}
	
}
