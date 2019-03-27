package com.ers.dao;

import java.util.ArrayList;

import com.ers.model.Ticket;

public interface TicketDao {
	
	//CREATE
	public int insertTicket(Ticket t, String user);
	
	//READ
	public ArrayList<Ticket> selectAllTickets(); 
	public ArrayList<Ticket> selectTicketByUsername(String username);
	public ArrayList<Ticket> selectTicketByType(String type); //LODGING, TRAVEL, FOOD, OTHER
	public ArrayList<Ticket> selectTicketByState(String state); //PENDING, APPROVED, DENIED
}
