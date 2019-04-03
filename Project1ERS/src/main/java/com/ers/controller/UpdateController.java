package com.ers.controller;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.ers.dao.TicketDaoImpl;

public class UpdateController {
	
	final static Logger logger = Logger.getLogger(HomeController.class.getName());

	public static String Update(HttpServletRequest request)
	{
		System.out.println(request);
//		Enumeration<String> params = request.getParameterNames();
//		
//		while (params.hasMoreElements())
//		{
//			String param = params.nextElement();
//			System.out.println(param + ": "+ request.getParameter(param));
//		}
		
		long id = Long.valueOf(request.getParameter("id"));
		String status = request.getParameter("newStatus");
		
		logger.info("Ticket " + id + " SET TO " + status);
		long ticketId = id;
		String newStatus = (status.equals("TicketApprove")) ? "APPROVED" : "DENIED";
		
		TicketDaoImpl ticketDaoImpl = new TicketDaoImpl();
		ticketDaoImpl.updateTicketStateById(ticketId, newStatus);
		
		return null;
	}
}
