package com.ers.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.TicketDaoImpl;
import com.ers.model.Ticket;
import com.ers.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class HomeController {
	public static String Home(HttpServletRequest request) {
		return null;
	}

	public static String TicketJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("In HomeController.TicketJSON");

		TicketDaoImpl ticketDaoImpl = new TicketDaoImpl();
		ArrayList<Ticket> ticketArray = ticketDaoImpl.selectAllTickets();

		User user = (User) request.getSession().getAttribute("User");

		try {
			String json = new Gson().toJson(user.getUsername()) + "*";
			for(Ticket t : ticketArray)
				json += new Gson().toJson(t) + "*";
			System.out.println(json);

			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
