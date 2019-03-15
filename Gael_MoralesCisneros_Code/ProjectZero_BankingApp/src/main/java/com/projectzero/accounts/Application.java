package com.projectzero.accounts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.projectzero.main.Register;
import com.projectzero.users.User;

public class Application extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float accountBalance;
	
	

	public Application(float accountBalance, Account customer) {
		super();
		this.accountBalance = accountBalance;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	//Serialization of txt file to be reviewed by Employee
	public static void accountApply(Application a) {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./Application.txt"));
			oos.writeObject(a);
			oos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Goes to Register class for thank you message and logout process
		Register.waitPage();

	}
	
}
