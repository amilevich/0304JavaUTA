package com.Project1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch (request.getRequestURI()) {

		case "/ChrisJarodProject1/html/Login.do":
			return LoginController.Login(request, response);

		case "/ChrisJarodProject1/html/Register.do":
			return RegisterController.Register(request);

		case "/ChrisJarodProject1/html/EHome.do":
			return EHomeController.Ticket(request);
			
		case "/ChrisJarodProject1/html/FHome.do":
			return FHomeController.Ticket(request);

		case "/ChrisJarodProject1/html/All.do":
			return FHomeController.ShowAll(request, response);
			
		case "/ChrisJarodProject1/html/FilterByUnresolved.do":
			return FHomeController.FilterByResolved(request, response,0);
			
		case "/ChrisJarodProject1/html/FilterByResolved.do":
			return FHomeController.FilterByResolved(request, response,1);

		case "/ChrisJarodProject1/html/Logout.do":
			return EHomeController.Logout(request);

		case "/ChrisJarodProject1/html/Data.do":
			return EHomeController.Data(request, response);

		default:
			return "/html/Login.html";
		}
	}
}
