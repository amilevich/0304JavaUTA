package com.revature.banking;

import java.io.Serializable;
import java.util.ArrayList;


import java.util.List;



public class Application implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2396595678122253109L;
	
	List<String> users;
	
	//single account
	public Application(String user) {
		users = new ArrayList<String>();
		users.add(user);
	}
	
	//joint account
	public Application(List<String> user){
		users = new ArrayList<String>();
		user.forEach(users::add);
		//for(String x : user)	users.add(x);
	}
	
	public List<String> getUsers(){
		return users;
	}
	
	public void setUsers(List<String> users) {
		this.users = users;
	}
	
	public int printInfo( ) {
		int numUsers = 0;
		if(users.size()==1) {
			System.out.println("Application for account with one owner for: " + users.get(0));
			numUsers = 1;
		}else {
			System.out.println("Application for joint account for: ");
			this.users.forEach(System.out::println);
			numUsers = this.users.size();
		}
		System.out.println("\nAction required: Please select an option (1-3)"
								  + "\n\t1. Approve Application "
								  + "\n\t2. Deny Application "
								  + "\n\t3. Go back to previous menu" );
		return numUsers;
	}
	
	
}