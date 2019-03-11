package com.projectzero.accounts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.projectzero.main.Register;

public class JointApplication extends Application{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Extra String for name of second account holder in joint account
	private String jointHolder;

	public JointApplication(float accountBalance, String jointHolder, Account customer) {
		super(accountBalance, customer);
	}

	public String getJointHolder() {
		return jointHolder;
	}

	public void setJointHolder(String jointHolder) {
		this.jointHolder = jointHolder;
	}
	
	
	//Serialization of txt file to be reviewed by Employee
	public static void accountApply(JointApplication a) {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./JointApplication.txt"));
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
