package appTester;

import java.util.ArrayList;

import appModels.Customer;

public class LoginTester {
	
	
	public static ArrayList<Customer> setUp() throws Exception {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Jimmy",123456,320,0));
		customers.add(new Customer("Dean",123456,720,0));
		return customers;
	}
	
	
	static boolean CheckForCustomers(String UserN, int password, ArrayList<Customer> c) 
	{	//for each customer login attempt, the Username and Password is checked against Database

		boolean check = false; int i;int j;int k = Integer.valueOf(password);
		//boolean to be returned
		//int i to return compareTo function output (compares string input to customer username records
		//int j = customer records password
		//int k = the integer value of input password
		ArrayList<Customer> customers = c;
				for (Customer cus : customers) 
				{
					i = cus.getUsername().compareTo(UserN); j = cus.getPassword();	
					
					if((i == 0) & (j == k)) 
					{
						return true; 
					}
				}	
				return check;//else return false
	}
}
