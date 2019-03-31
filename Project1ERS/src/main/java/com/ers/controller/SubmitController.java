package com.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.ers.dao.TicketDaoImpl;
import com.ers.model.Ticket;
import com.ers.model.User;

public class SubmitController {

	public static String Submit(HttpServletRequest request)
	{
		String type = request.getParameter("SubmittedType"); 	// returns value of type dropdown
		String amount = request.getParameter("SubmittedAmount");
		String description = request.getParameter("SubmittedDescription");
		
		User user = (User)request.getSession().getAttribute("User");
		Ticket ticket = new Ticket(Double.valueOf(amount), type, "PENDING");
		
		TicketDaoImpl tdi = new TicketDaoImpl();
		tdi.insertTicket(ticket, user.getUsername());
		
		return "/HTML/Load.html";
	}
}
