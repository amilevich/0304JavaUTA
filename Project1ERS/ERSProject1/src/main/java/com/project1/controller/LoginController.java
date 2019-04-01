package com.project1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.dao.DaoReimbursementImpl;
import com.project1.dao.DaoUsersImpl;
import com.project1.model.ReimbResponse;
import com.project1.model.UserReimb;
import com.project1.model.Users;

public class LoginController {

	public static String Login(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DaoUsersImpl daoUsersImpl = new DaoUsersImpl();
		Users user = new Users();
		user = daoUsersImpl.validateUser(username, password);

		DaoReimbursementImpl daoReimbursementImpl = new DaoReimbursementImpl();
		List<UserReimb> userReimb = daoReimbursementImpl.selectAllReimbursements(user.getErsUsersId());
		
		ReimbResponse userReimbResponse = new ReimbResponse();
		
		userReimbResponse.reimbList = userReimb;
		userReimbResponse.userFirstname = user.getUserFirstname();
		userReimbResponse.userLastname = user.getUserLastname();
		userReimbResponse.userEmail = user.getUserEmail();
		userReimbResponse.userRoleId = user.getUserRoleId();
		userReimbResponse.ersUsername = user.getErsUsername();
		userReimbResponse.ersPassword = user.getErsPassword();
		userReimbResponse.ersUsersId = user.getErsUsersId();

		request.getSession().setAttribute("ReimbResponse",userReimbResponse);
			
		return "ViewReimb.html";
		
	}
}
