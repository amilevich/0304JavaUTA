package appTester;

import java.util.ArrayList;

import appModels.Customer;

public class DuplicateUserTester {

	public static ArrayList<Customer> setUp() throws Exception {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Jimmy",123456,320,0));
		customers.add(new Customer("Dean",123456,720,0));
		return customers;
	}
	
	static boolean CheckForDuplicateUser(String UserN, ArrayList<Customer> c) {
		ArrayList<Customer> cust = c;
		boolean check = false;int i;
		for(Customer cus : cust) {
			i = cus.getUsername().compareTo(UserN);
			if(i == 0) {check = true;}
		}
	return check;
	}
}

