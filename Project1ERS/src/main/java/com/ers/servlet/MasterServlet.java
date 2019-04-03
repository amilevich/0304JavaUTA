package com.ers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.RequestHelper;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Logger;
import java.util.logging.Logger;

public class MasterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----======----\nIn MasterServlet, doGet()");
			RequestHelper.process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In MasterServlet, doPost()");
		String targetURL = RequestHelper.process(request, response);
		request.getRequestDispatcher(targetURL).forward(request, response);
	}
}
