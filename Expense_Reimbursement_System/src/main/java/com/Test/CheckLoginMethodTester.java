package com.Test;

import java.util.ArrayList;

import com.Model.User;


public class CheckLoginMethodTester {

	static boolean CheckForUsers(String UserN, int password, ArrayList<User> U) 
	{	//for each customer login attempt, the Username and Password is checked against Database

		boolean check = false; int i;int j;int k = Integer.valueOf(password);
		//boolean to be returned
		//int i to return compareTo function output (compares string input to User username records
		//int j = customer records password
		//int k = the integer value of input password
		ArrayList<User> Users = U;
				for (User User : Users) 
				{
					i = User.getUserName().compareTo(UserN); j = User.getPassWord();	
					
					if((i == 0) & (j == k)) 
					{
						return true; 
					}
				}	
				return check;//else return false
	}
	
}
