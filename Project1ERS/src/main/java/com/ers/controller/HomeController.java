package com.ers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeController {
	public static String Home(HttpServletRequest request) {
		return null;
	}
	
	public static String UserJSON(HttpServletRequest request, HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("User");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
