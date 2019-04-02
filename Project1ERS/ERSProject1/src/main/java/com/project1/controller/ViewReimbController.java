package com.project1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.DaoReimbursementImpl;
import com.project1.dao.DaoUsersImpl;
import com.project1.model.ReimbResponse;
import com.project1.model.UserReimb;
import com.project1.model.Users;

public class ViewReimbController {

	public static String ViewReimb(HttpServletRequest request) {
		return null;
	}
	
	public static String UserJSON(HttpServletRequest request, HttpServletResponse response) {
		ReimbResponse userReimbResponse = new ReimbResponse();
		if (request.getParameter("id") == null) {
			userReimbResponse = (ReimbResponse) request.getSession().getAttribute("ReimbResponse");
		}
		else {
			int userId = Integer.parseInt(request.getParameter("id"));
			DaoUsersImpl daoUsersImpl = new DaoUsersImpl();
			Users user = new Users();
			user = daoUsersImpl.getUserById(userId);
	
			DaoReimbursementImpl daoReimbursementImpl = new DaoReimbursementImpl();
			List<UserReimb> userReimb = daoReimbursementImpl.selectAllReimbursements(user.getErsUsersId());
			
			userReimbResponse.reimbList = userReimb;
			userReimbResponse.userFirstname = user.getUserFirstname();
			userReimbResponse.userLastname = user.getUserLastname();
			userReimbResponse.userEmail = user.getUserEmail();
			userReimbResponse.userRoleId = user.getUserRoleId();
			userReimbResponse.ersUsername = user.getErsUsername();
			userReimbResponse.ersPassword = user.getErsPassword();
			userReimbResponse.ersUsersId = user.getErsUsersId();
		}
		
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
