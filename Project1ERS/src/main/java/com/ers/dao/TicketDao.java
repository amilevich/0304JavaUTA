package com.ers.dao;

import java.util.ArrayList;

import com.ers.model.Ticket;

public interface TicketDao {
	
	//CREATE
	public int insertTicket(Ticket t);
	
	//READ
	public ArrayList<Ticket> selectAllTickets(); 
	public ArrayList<Ticket> selectTicketsByUsername(String username); //username alone, chosen by employee
	public ArrayList<Ticket> selectTicketsByType(String type); //LODGING, TRAVEL, FOOD, OTHER //type alone, chosen by manager
	public ArrayList<Ticket> selectTicketsByState(String state); //PENDING, APPROVED, DENIED //state alone, chosen by manager
	public ArrayList<Ticket> selectByAllFilters(String username, String type, String state);
	
	// UPDATE
	public void updateTicketStateById(long id, String state);
}
