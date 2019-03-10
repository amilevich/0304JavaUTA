package com.banking;

public class User
{
	
	private String username;
	private String password;
	
	public User()
	{	}
	
	public User(String uName, String passwd)
	{
		username = uName;
		password = passwd;
	}
	
	public boolean getLogin(String user, String pass)
	{
		if (username.equals(user))
		{
			if (password.equals(pass))
				return true;
		}
		return false;
	}
	
	public String getUsername()
	{
		return username;
	}
}
