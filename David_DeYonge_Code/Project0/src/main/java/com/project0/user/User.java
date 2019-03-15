package com.project0.user;

import com.project0.customer.Customer;

public interface User 
{
	public void Login(String userName,String passWord);
	public void Logout();
	public void Register();
	public void DisplayInfo(Customer customer);
	public void DisplayBalance(Customer customer,int accountNumber);
	public void DisplayPersonalInfo(Customer cutomer);
		
	
}
