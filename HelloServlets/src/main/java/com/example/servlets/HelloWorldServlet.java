package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String favoriteColor = "YellowGreenBurntOrangeLegs";
		
		PrintWriter printWriter = response.getWriter();
		printWriter.write("<h1>Your favorite color is: " + favoriteColor + "</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		//response.sendRedirect("https://media.giphy.com/media/26FPCXdkvDbKBbgOI/giphy.gif");
		request.getRequestDispatcher("Home.html").forward(request, response);
	}
}
