package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.model.Ticket;

public class TicketDaoImpl implements TicketDao {

	// insert
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static String url = "jdbc:oracle:thin:@mysqldatabase3.cwjd6odobf4o.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "angellocastro";
	private static String password = "Nightmarish1.";
	
	@Override
	public int insertTicket(Ticket t, String user) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_Tickets VALUES(?,?,?,?)");
			ps.setDouble(1, t.getAmount());
			ps.setString(2, t.getType());
			ps.setString(3, t.getState());
			ps.setString(4, user);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<Ticket> selectAllTickets() {
		ArrayList<Ticket> ticketArray = new ArrayList<Ticket>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Tickets");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ticketArray.add(new Ticket(rs.getDouble("ticket_amount"), rs.getString("ticket_type"), rs.getString("ticket_state")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketArray;
	}

	@Override
	public ArrayList<Ticket> selectTicketsByUsername(String user) {
		ArrayList<Ticket> ticketArray = new ArrayList<Ticket>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Tickets WHERE ticket_user=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ticketArray.add(new Ticket(rs.getDouble("ticket_amount"), rs.getString("ticket_type"), rs.getString("ticket_state")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketArray;
	}
	
	@Override
	public ArrayList<Ticket> selectTicketsByType(String type) {
		ArrayList<Ticket> ticketArray = new ArrayList<Ticket>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Tickets WHERE ticket_type=?");
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ticketArray.add(new Ticket(rs.getDouble("ticket_amount"), rs.getString("ticket_type"), rs.getString("ticket_state")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketArray;
	}
	
	@Override
	public ArrayList<Ticket> selectTicketsByState(String state) {
		ArrayList<Ticket> ticketArray = new ArrayList<Ticket>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Tickets WHERE ticket_state=?");
			ps.setString(1, state);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ticketArray.add(new Ticket(rs.getDouble("ticket_amount"), rs.getString("ticket_type"), rs.getString("ticket_state")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketArray;
	}
	
	public ArrayList<Ticket> selectByAllFilters(String username, String type, String state){
		ArrayList<Ticket> ticketArray = new ArrayList<Ticket>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Tickets WHERE ticket_user=? AND ticket_type=? AND ticket_state=?");
			ps.setString(1, username);
			ps.setString(2, (type.equals("TypeNull")) ? "*" : type);
			ps.setString(3, (state.equals("StatusNull")) ? "*" : state);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ticketArray.add(new Ticket(rs.getDouble("ticket_amount"), rs.getString("ticket_type"), rs.getString("ticket_state")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketArray;
	}

}
