package com.ers.model;

public class Ticket {
	
	long id;
	double amount;
	String type, state, username, description;
	public Ticket(long id, double amount, String username, String type, String state, String description) {
		this.id = id;
		this.amount = amount;
		this.username= username;
		this.type = type;
		this.state = state;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", amount=" + amount + ", type=" + type + ", state=" + state + ", username="
				+ username + ", description=" + description + "]";
	}
	

}