package com.banking;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable
{
	
	private static final long serialVersionUID = -707950371174938580L;
	private String username;
	// TODO: Replace with SHA-256 Hash of password for Serialization
	private String password;
	
//	public User()
//	{	}
	
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
	
	public abstract ArrayList<String> getAccountOperations(Account acct);
	
	public String toString()
	{
		return username;
	}
}
