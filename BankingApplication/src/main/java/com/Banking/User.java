package com.Banking;

public class User {
	//list of all possible users
	
	public boolean register = false;
	
	public void registerAccount() {
		if(register == false) {
			register = true;
			
		}else {
			System.out.println("You have already registered for an account.");
		}
	}
	
	
	
}
