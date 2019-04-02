package com.ers.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.ers.dao.TicketDaoImpl;

public class UpdateController {

	public static String Update(HttpServletRequest request)
	{
		System.out.println(request);
		Enumeration<String> params = request.getParameterNames();
		
		while (params.hasMoreElements())
		{
			String param = params.nextElement();
			System.out.println(param + ": "+ request.getParameter(param));
		}
		
		long ticketId = Long.valueOf(request.getParameter("id"));
		String newStatus = (request.getParameter("newStatus").equals("TicketApprove")) ? "APPROVED" : "DENIED";
		
		TicketDaoImpl ticketDaoImpl = new TicketDaoImpl();
		ticketDaoImpl.updateTicketStateById(ticketId, newStatus);
		
		return null;
	}
}
