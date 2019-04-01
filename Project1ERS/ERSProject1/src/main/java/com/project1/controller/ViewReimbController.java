package com.project1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.model.ReimbResponse;
import com.project1.model.UserReimb;
import com.project1.model.Users;

public class ViewReimbController {

	public static String ViewReimb(HttpServletRequest request) {
		return null;
	}
	
	public static String UserJSON(HttpServletRequest request, HttpServletResponse response) {
		ReimbResponse userReimbResponse = (ReimbResponse) request.getSession().getAttribute("ReimbResponse");

		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(userReimbResponse));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
