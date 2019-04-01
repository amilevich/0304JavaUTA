package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request uri: "+request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/ProjectOne_ExpenseReimbursementSystem/html/Login.do":
			return LoginController.Login(request);
		case "/ProjectOne_ExpenseReimbursementSystem/html/ReimbRequest.do":
			return ReimbRequestController.ReimbRequest(request);
		case "/ProjectOne_ExpenseReimbursementSystem/html/UpdateReimburse.do":
			return UpdateReimburseController.UpdateReimburse(request);
		case "/ProjectOne_ExpenseReimbursementSystem/html/JSON.do":
			return JSONController.PopulateTable(request, response);
		case "/ProjectOne_ExpenseReimbursementSystem/html/empJSON.do":
			return JSONController.PopulateEmpTable(request, response);
		default:
			return "/html/Index.html";
		}
	}

}
