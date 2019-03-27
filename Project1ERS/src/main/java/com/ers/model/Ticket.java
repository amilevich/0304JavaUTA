package com.ers.model;

public class Ticket {
	
	double amount;
	String type, state;
	public Ticket(double amount, String type, String state) {
		super();
		this.amount = amount;
		this.type = type;
		this.state = state;
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
	@Override
	public String toString() {
		return "Ticket [amount=" + amount + ", type=" + type + ", state=" + state + "]";
	}

}