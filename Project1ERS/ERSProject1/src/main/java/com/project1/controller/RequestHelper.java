package com.project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		String testCase = request.getRequestURI();
		switch(request.getRequestURI()) {
		
		case "/ERSProject1/HTML/Login.do":
			return LoginController.Login(request);
			
		case "/ERSProject1/HTML/SubmitReimb.do":
			return SubmitReimbController.SubmitReimb(request);
			
		case "/ERSProject1/HTML/Register.do":
			return RegisterController.Register(request);
			
		case "/ERSProject1/HTML/Update.do":
			return RegisterController.Update(request);
			
		case "/ERSProject1/HTML/UserJSON.do":
			return ViewReimbController.UserJSON(request, response);
			
		default:
			return "/html/Login.html";
		}
	}
}