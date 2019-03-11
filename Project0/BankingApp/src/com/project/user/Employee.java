package com.project.user;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class Employee extends User {

	public Employee(String username, String password, String type, String name) {
		super(username, password, type, name);
	}

	public void viewCustomers (Map <String,String[]> map) {
		for (String[] value : map.values()) {
		    System.out.println(Arrays.toString(value));
		}
	}

	public void viewCustomerAccount(String username, Map <String,Integer> map) {
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if (pair.getKey().equals(username)) {
	            System.out.println(pair.getKey() + " has an account balance of: " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
	        }
	    }
	}


	
}
