package com.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.driver.main;
import com.bank.model.app;

import oracle.net.aso.k;


public class appDaoimpl implements appDao {
	final static Logger logger = Logger.getLogger(appDaoimpl.class);
	private static String url = "jdbc:oracle:thin:@mysqloracle.ccqv64zpxxsw.us-west-1.rds.amazonaws.com:1521:orcl";
	private static String username = "guess1";
	private static String password = "pss12345";
	
	public  int Register(app ap) {
				
			try (Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("INSERT INTO USERLOGIN VALUES (?,?,?,?,?)");
				ps.setString(1, ap.getUserID());
				ps.setString(2, ap.getPassword());
				ps.setString(3, ap.getFirstName());
				ps.setString(4, ap.getLastName());
				ps.setString(5, ap.getRole());
				ps.executeUpdate();
				
				PreparedStatement admin = conn.prepareStatement("INSERT INTO ADMINTASK (USERID, PENDING) VALUES (?,?)");
				admin.setString(1,ap.getUserID());
				admin.setString(2, appDaoimpl.CurrentTime());
				admin.executeUpdate();
				System.out.println("Your registration is completed. Your application is being reviewed. Please revisite the site in a few days..");
				
			}catch (SQLException e){
				e.printStackTrace();
			}
		
		return 0;
	}

	@Override
	public app FindAccNum(String id, String pass) {
		// TODO Auto-generated method stub
		System.out.println(id + pass);
		app myapp = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			
			//SELECT USERID, PASSWORD, USERROLE FROM USERLOGIN WHERE USERID='songvirak_@gmail.com' AND PASSWORD ='song1234';
			//PreparedStatement ps = conn.prepareStatement("SELECT USERID, PASSWORD, USERROLE FROM USERLOGIN WHERE USERID=? AND PASSWORD =?");
			PreparedStatement ps = conn.prepareStatement("SELECT USERID, PASSWORD, USERROLE FROM USERLOGIN WHERE USERID=? And PASSWORD=?");
			ps.setString(1, id);
			ps.setString(2, pass);
			
			
		
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				myapp = new app();
				myapp.setUserID(rs.getString("USERID"));
				myapp.setPassword(rs.getString("PASSWORD"));
				myapp.setRole(rs.getString("USERROLE")); 
				
				/*System.out.println(rs.getString("USERID"));
				System.out.println(rs.getString("PASSWORD"));
				System.out.println(rs.getString("USERROLE"));*/
				
			}
			
			
			//System.out.println(myapp+"Your registration is completed. Your application is being reviewed. Please revisite the site in a few days..");
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return myapp;
	}
	
/*	public app adminTask() {
		app myapp = null;
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ADMINTASK WHERE PENDING IS NOT NULL");
			ResultSet rs = ps.executeQuery();
			myapp = new app();
			while (rs.next()) {
				myapp.add(new app(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myApp;
	}*/
	
	@Override
	public List<app> adminTask() {
		// TODO Auto-generated method stub
		
		List<app> myApp = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ADMINTASK WHERE PENDING IS NOT NULL");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				app a = new app();
				a.setUserID(rs.getString(1));
				a.setPENDING(rs.getString(2));
				a.setAPPROVED(rs.getString(3));
				a.setCANCELLED(rs.getString(4));
				a.setCLOSED(rs.getString(5));
				myApp.add(a);
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myApp;
	}
	
	/*public List<app> SearchByIDAdmin(String userId) {
		// TODO Auto-generated method stub
		
		
		
		List<app> myApp = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ADMINTASK WHERE USERID =?");
			ps.setString(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				//myApp.add(new app(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)) );
				app a = new app();
				a.setUserID(rs.getString(1));
				a.setPENDING(rs.getString(2));
				a.setAPPROVED(rs.getString(3));
				a.setCANCELLED(rs.getString(4));
				a.setCLOSED(rs.getString(5));
				myApp.add(a);
			
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myApp;
	}*/
	
	
	

	@Override
	public List<app> ViewAccount() {
		// TODO Auto-generated method stub
		
		List<app> myApp = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT USERID, PASSWORD FROM USERLOGIN");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				myApp.add(new app(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myApp;
		
		
	}

	@Override
	public int UpdateAcc(app ap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DeleteAcc(app ap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean HomeScreen() {
		// TODO Auto-generated method stub
		
	//	Scanner userInput = new Scanner(System.in);  // Create a Scanner object
		boolean z= false;
		boolean t= false;
		do {
			logger.info("application started");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Please Enter number:");
			String s = appDaoimpl.input();
			
		    switch (s){
		    	case "1": {
		    		String x,y;
		    		int i=0;
		    		app ap = new app();
		    		do {
		    		System.out.println("Enter email address as your UserID?");
		    			x= appDaoimpl.input();
		    		System.out.println("Enter email address again?");	
		    			y=appDaoimpl.input();
		    			i++;
		    			if (x.equals(y)) {  
		    				ap.setUserID(x);
		    				break;		    				
		    			}
		    			
		    				if (i==2){
					    			i=0;
					    			
					    			System.out.println("3. Exit");
					    			System.out.println("or press any key to continoue.. ");
					    			s=appDaoimpl.input();
					    			if (s.equals("3")) {
					    				z=true;
					    				x=y="";
					    				i=0;
					    				break;
					    			}		
			    			
			    			} else if (t==false) {
			    			System.out.println("Your enter was not matched");
			    			}
		    			
		    			}while(t==false);
		    				t=false;
				    		if (z==true){
				    			break;
				    		}
					    	do {
					    		if (t==false) {	
					    			System.out.println("Enter your password");
						    		x= appDaoimpl.input();
						    		System.out.println("Enter your password again?");	
						    		y=appDaoimpl.input();
						    		i++;
						    		if (x.equals(y)) {
						    			ap.setPassword(x);
						    			t=true;
						    			i=0;
						    		}
						    		
						    		if (i==2) {
						    			i=0;
						    			System.out.println("3. Exit");
						    			System.out.println("or press any key to continoue.. ");
						    			s=appDaoimpl.input();
						    			if (s.equals("3")) {
						    				
						    				z=true;
						    				x=y="";					  
						    				break;
						    			}		
						    			
						    		} else if (t==false) {
						    			
						    			System.out.println("Your enter was not matched");
						    		}
					    		}
			    			}while(t==false);
					     t=false;
				    	 if (z==true) {
			    			
			    			break;
			    		}
					   
				    	if (t==false)	{
				    	System.out.println("Enter your FirstName");
				    	ap.setFirstName(appDaoimpl.input());
				    		
				    	System.out.println("Enter your LastName");
				    	ap.setLastName(appDaoimpl.input());
				    	ap.setRole("CUST");
				    	Register(ap);
				    				    	
				    	}
				    		
				    	
				    	break;
		    		
		    	}
		    	case "2": {
		    		String x,y, g;
		    		app a = new app();
		    		System.out.println("UserID:");
		    		x = this.input();
		    		System.out.println("Password:");
		    		y = this.input();
		    		a = this.FindAccNum(x, y);
		    		
		    		g = a.getRole();
		    		g=g.toUpperCase();
		    		System.out.println(g);
		    		//if(a.getRole().equals("ADMIN")) {
		    		if (g.equals("ADMIN")) {
		    			//System.out.println("Hello");
		    			System.out.println(g);
		    			adminview(g);
		    				
		    		}else if(g.equals("CUST")) {
		    			boolean b = false;
		    			do { String k="", w;
		    			
		    				w=appDaoimpl.custinput(g);
		    				
		    				if (w.equals("1")) { //view
		    					this.CustomerView(x);	    		   					
		    					//app findAcc = this.FindAccNum(x);
		    					//app Balance = this.CustomerBalance(findAcc.getAccNum());
		    					
				    			//System.out.print(this.CustomerView(x).CustomerView()); // need to print with tostring to see it work correctly
				    			System.out.println(CustomerView(x).CustomerView());
				    			//System.out.print(findAcc.FindAccNum());
				    			//System.out.println(" Balance: "+ Balance.CustomerBalanceToString() );
				    			
		    				}else if (w.equals("2")) {//Deposite
		    					
		    				}else if (w.equals("3")) {//withdraw
		    					
		    				}else if (w.equals("4")) {//transfer
		    					
		    				}   			
		    			
			    			if (k.equals("exit")) {
			    				b= true;
			    			}
		    			}while (b==false);
		    		}else if(a.getRole().equals("Emp"))
		    			//Employee view
		    		
		    		t = true;
		    		break;
		    	}
		    	case "3": {
		    		System.out.println("You are now exit the application.");
		    		t = true;
		    		System.exit(1);
		    		break;
		    	}
		    	default: System.out.println("Please Enter number");
		    		
		  }	    	
	    }while (t==false);
		
		return false;
	}
	public static String custinput(String admin) {
		String in;
		System.out.println("1. View");
		System.out.println("2. Deposite");
		System.out.println("3. Withdraw");
		System.out.println("4. Transfer");
		admin = admin.toUpperCase();
		if (admin.equals("ADMIN")) {
		System.out.println("5. View New Customer");	
		}
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	 	
	    in = myObj.nextLine();  // Read user input
	  
		return in;
	}
	
	public app CustomerView(String userid) {
		// TODO Auto-generated method stub
		System.out.println(userid);
		app myapp = new app();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			
			//SELECT FIRSTNAME, LASTNAME , USERROLE, USERLOGIN.USERID, JOINTACC.ACCNUM, USERPROFILE.BALANCE FROM USERLOGIN RIGHT JOIN JOINTACC ON USERLOGIN.USERID = JOINTACC.USERID RIGHT JOIN USERPROFILE ON USERPROFILE.ACCNUM = JOINTACC.ACCNUM WHERE JOINTACC.USERID = 'A001';
			//PreparedStatement ps = conn.prepareStatement("SELECT USERID, FIRSTNAME, LASTNAME, USERROLE FROM USERLOGIN WHERE USERID=?");
			PreparedStatement ps = conn.prepareStatement("SELECT FIRSTNAME, LASTNAME , USERROLE, USERLOGIN.USERID, JOINTACC.ACCNUM, USERPROFILE.BALANCE FROM USERLOGIN RIGHT JOIN JOINTACC ON USERLOGIN.USERID = JOINTACC.USERID RIGHT JOIN USERPROFILE ON USERPROFILE.ACCNUM = JOINTACC.ACCNUM WHERE JOINTACC.USERID =?");
			ps.setString(1, userid);
		
		ResultSet rs = ps.executeQuery();
			while (rs.next()) {
								
				myapp.setUserID(rs.getString("USERID"));
				myapp.setFirstName(rs.getString("FIRSTNAME"));
				myapp.setLastName(rs.getString("LASTNAME"));
				myapp.setRole(rs.getString("USERROLE"));
				myapp.setAccNum(rs.getString("ACCNUM"));
				myapp.setBALANCE(rs.getInt("BALANCE"));	
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return myapp;
	}
	
	
	public app Deposit(String Acc) {
		// TODO Auto-generated method stub
		
		app myapp = new app();
		
		//app i ;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			//i= MyBalance(Acc);
			//System.out.print(i.getBALANCE());
			//UPDATE USERPROFILE SET BALANCE =(SELECT BALANCE FROM USERPROFILE WHERE ACCNUM = 'A001')+500 WHERE ACCNUM = 'A001';
													//UPDATE USERPROFILE SET BALANCE =500 WHERE ACCNUM = 'A001';
			
			PreparedStatement ps = conn.prepareStatement("UPDATE USERPROFILE SET BALANCE =? WHERE ACCNUM =?");
			ps.setInt(1, 100);
			//ps.setInt(2, i.getBALANCE());
			ps.setString(2, Acc);
		
			ResultSet rsup = ps.executeQuery();
				while (rsup.next()) {
					myapp.setBALANCE(rsup.getInt("BALANCE"));	
					myapp.setAccNum(rsup.getString("ACCNUM"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
			
		return myapp;
	}
	
	public app MyBalance(String Acc) {
		app myapp = new app();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			//UPDATE USERPROFILE SET BALANCE =(SELECT BALANCE FROM USERPROFILE WHERE ACCNUM = 'A001')+500 WHERE ACCNUM = 'A001';
			PreparedStatement pssel = conn.prepareStatement("SELECT BALANCE FROM USERPROFILE WHERE ACCNUM =?");
			pssel.setString(1, Acc);
			ResultSet rs = pssel.executeQuery();
				while (rs.next()) {
					myapp.setBALANCE(rs.getInt("BALANCE"));	
				}				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		return myapp;
	}
	
	public app CustomerBalance(String Acc) {
		// TODO Auto-generated method stub
		app myapp = new app();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERPROFILE WHERE ACCNUM =?");
		ps.setString(1, Acc);
		
		ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				myapp.setBALANCE(rs.getInt("BALANCE"));	
				myapp.setAccNum(rs.getString("ACCNUM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return myapp;
	}
	
	public app CustomerJoint(String Acc) {
		// TODO Auto-generated method stub
		app myapp = new app();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM JOINTACC WHERE ACCNUM =?");
		ps.setString(1, Acc);
		ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				myapp.setAccNum(rs.getString("ACCNUM"));	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return myapp;
	}
	
	/*public app FindAccNum(String Userid) {
		// TODO Auto-generated method stub
		app myapp = new app();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT ACCNUM FROM JOINTACC WHERE USERID =?");
			ps.setString(1, Userid);
			
		ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				myapp.setAccNum(rs.getString("ACCNUM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return myapp;
	}*/
	

	public List<app> adminview(String user) {
	
		//show all new customers
		List<app> myapp;
		myapp = this.adminTask();// Select all pending new customer on admin task table
		

		String approve = "";
		
			String adminMenu="";
			//Admin menu
			adminMenu=appDaoimpl.custinput(user);
			adminMenu = adminMenu.toUpperCase();
			
			if (adminMenu.equals("1")) {
				System.out.println("Customer view");
				
			}else if (adminMenu.equals("2")) {
				System.out.println("call deposite function");
			}else if (adminMenu.equals("3")){
				System.out.println("call withdraw function");
			}else if (adminMenu.equals("4")) {
				System.out.println("call transfer view");
				
			}
			
				do {
					if (adminMenu.equals("5")) {
						for (int i=0; i<myapp.size(); i++) {
							System.out.println( myapp.get(i).pendingAccounts() );
							
						}
					}
			
			
					System.out.println("Enter E to exit or Enter customer ID to be approved or rejected");		
					String UserID = appDaoimpl.input();
					UserID = UserID.toUpperCase();
					if (UserID.equals("E")) {
						break;
					}else {
					
					System.out.println("A - Aproved\nR-Reject");
					approve = appDaoimpl.input();
					approve = approve.toUpperCase();
					}
					switch(approve)
					{
						case "A": {
							this.approveAccount(UserID);
							System.out.println("You has aprroved this customer: " + UserID );
							
							for (int i=0; i<myapp.size(); i++) {
								System.out.println( myapp.get(i).pendingAccounts() ); // read from Database to review on console. 
							}
							break;
						}
						case "R": {
							this.rejectAccount(UserID);
							System.out.println("You has reject this customer: " + UserID );
							for (int i=0; i<myapp.size(); i++) {
								System.out.println( myapp.get(i).pendingAccounts() );
							}
							break;
						}
						default: {
							System.out.println("Wrong option");
							break;
						}
					}
				}while(approve.equals("A") || approve.equals("R") || approve.equals("E"));
				
				
				return myapp;
	}
	
	public void approveAccount(String userID) {
		//UPDATE ADMINTASK SET APPROVED = '02-03-2018' WHERE USERID = 'ASD@GMAIL.COM';
		//UPDATE ADMINTASK SET APPROVED = '02-03-2018' WHERE USERID = 'ASD@GMAIL.COM';
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ADMINTASK SET APPROVED =? WHERE USERID = ?");
			//ps.setString(1, appDaoimpl.CurrentTime());
			ps.setString(1, appDaoimpl.CurrentTime());
			ps.setString(2, userID);
			ps.executeUpdate();
			
		/*	//INSERT INTO USERPROFILE (ACCNUM, BALANCE) VALUSE ('A001', 0);
			PreparedStatement MYPS = conn.prepareStatement("INSERT INTO USERPROFILE (ACCNUM, BALANCE) VALUSE (?,?)");
			//System.out.println(this.randomNumber());
			MYPS.setString(1, this.randomNumber().toString());
			MYPS.setInt(2, 0);
			MYPS.executeUpdate();*/
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rejectAccount(String userID) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ADMINTASK SET CANCELLED =? WHERE USERID =?");
			ps.setString(1, appDaoimpl.CurrentTime());
			ps.setString(2, userID);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public String randomNumber() {
		String s="";
			ArrayList<Byte> list = new ArrayList<Byte>(); 
			for (byte i = 0; i < 10; i++) { 
			list.add(i); 
			}  
			Collections.shuffle(list); 
			
			for (byte i = 0; i < 10; i++) { 
				s = s+list.get(i).toString();
				}
			return s;
			
	}
	
	
	public static String input() {
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	 	//System.out.println("");
	    //System.out.println("Enter username:");
	    String in = myObj.nextLine();  // Read user input
	   // System.out.println("Username is: " + userName);  // Output user input 
		return in;
	}
	
	public static String CurrentTime() {
		
		DateFormat date = new SimpleDateFormat("E MM-dd-YYYY hh:mm:ss a zzz");
		//DateFormat date = new SimpleDateFormat("MM-dd-YYYY");
		Date dateObj = new Date();
		return date.format(dateObj);
		
	}
}
