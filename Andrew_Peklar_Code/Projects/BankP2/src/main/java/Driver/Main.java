package Driver;
import com.dbbank.dao.*;
import com.dbbank.model.*;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;



//import oracle.jdbc.*;

public class Main {
	
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		//SchemaUtils.viewUsers();
		mainMenu();
	}

	
	
	
	
	
	
	
	public static void mainMenu() {
		// header
		System.out.println("\r\n" + "\t                                    __            \r\n"
				+ "\t|  | _| _ _  _  _  |_ _   |_|_  _  |__) _  _ |   \r\n"
				+ "\t|/\\|(-|(_(_)|||(-  |_(_)  |_| )(-  |__)(_|| )|(  \r");
		// user prompt
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Please select an option matching a value: \r" + "\n\t 1. Login to account"
				+ "\n\t 2. Register for an account" + "\n\t 3. Perform a safe Shut Down\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Option: \t");

		// loop through inputs until valid

	//	String menuInputs = menuInput(3, scan.next());

		// route from selection
		switch (scan.next()) {
		case "1":
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			login();
			break;
		case "2":
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			//register();
			break;
		case "3":
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("~~~~~~~~~~~~ Farewell! ~~~~~~~~~~~~");
			scan.close();
			break;
		default: // should be impossible to reach here
			mainMenu();
			break;
		}
	}
	
	private static void login() {
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\tLOGIN SCREEN");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("To go back, simply enter \"b\"");

		System.out.print("\nPlease enter your Username: \t");
		String username = scan.next();
		if (username.equals("b"))		mainMenu();

		System.out.print("\nPlease enter your Password: \t");
		String password = scan.next();
		if (password.equals("b"))		mainMenu();
		
		while(!SchemaUtils.UserLoginCheck(username, password)) {
			System.out.println("\n\n\nInvalid Username or Password!\n\nPlease try again...\n\n\n");
			System.out.print("\nPlease enter your Username: \t");
			username = scan.next();
			if (username.equals("b"))		mainMenu();

			System.out.print("Please enter your Password: \t");
			password = scan.next();
			if (password.equals("b"))		mainMenu();
		}
		
		int i = SchemaUtils.setUser(username, password).getAccountType();
		
		switch(i) {
			case 0 :
				customerMenu(new CustomerDaoImpl().selectCustomerByID(SchemaUtils.getUser().getUserID()));
				break;
			case 1 :
				employeeMenu(SchemaUtils.getUser());
				break;
			case 2 : 
				adminMenu(SchemaUtils.getUser());
				break;
			default:
				System.out.println("\n\nAccount is waiting for approval from an administratior.");
				System.out.println("Please try again later...\n\n");
				mainMenu();
		}

	}



	public static void adminMenu(Users thisUser) {
		System.out.println("\n\n\n\n\t\t\t ---------- IN THE ADMIN MENU ----------");
		System.out.println(thisUser.toString());
	}


	private static void employeeMenu(Users thisUser) {
		// TODO Auto-generated method stub
		System.out.println("\n\n\n\n\t\t\t ---------- IN THE Employee MENU ----------");
		System.out.println(thisUser.toString());
		
	}


	private static void customerMenu(Customer selectCustomerByID) {
		System.out.println("\n\n\n\n\t\t\t ---------- IN THE CUSTOMER MENU ----------");
		System.out.println(selectCustomerByID.toString());
	}

	
}
