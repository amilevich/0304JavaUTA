package com.bank.driver;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bank.dao.appDaoimpl;
import com.bank.model.app;

public class main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		appDaoimpl myappDaoimpl = new appDaoimpl();
		myappDaoimpl.HomeScreen();
		
		//app a = new app();
		
	//	System.out.println(myappDaoimpl.CustomerView("sss@gmail.com").CustomerView()); // working code
	//	System.out.println(myappDaoimpl.CustomerBalance("A003").CustomerBalanceToString());// working code
	//	System.out.println(myappDaoimpl.MyBalance("A003").Deposite());
		
		
		System.out.println(myappDaoimpl.Deposit("A003").Deposite());
		
	/*	System.out.println("HellosQL");
		app a = new app();
		a.setUserID("Kanica@yahoo.com");*/
	//	myappDaoimpl.approveAccount(a.getUserID());
	//	myappDaoimpl.rejectAccount("ASD@GMAIL.COM");
		
		//myappDaoimpl.ViewAccount();
		
		//myappDaoimpl.randomNumber();
	
	
	}
	

}
