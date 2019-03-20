package Driver;

import com.dbbank.dao.UserDaoImpl;
import com.dbbank.model.Users;
import com.dbbank.dao.*;
import com.dbbank.model.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Scanner;

public class SchemaUtils {
	
	public static Users currentUser;
	public static Customer currentCustomer;
	public static Scanner scani = new Scanner(System.in);
	
	//rework
	public static void insertUser(String b, String c) {
		Users one = new Users();
		UserDaoImpl ume = new UserDaoImpl();
		ume.insertUsers(one);
		currentUser = ume.selectUserByName(b, c);
	}
	
	public static void viewUsers() {
		System.out.println("UID\tUsername\tPassword\tAccountType");
		System.out.println("---------------------------------------------------------");
		new UserDaoImpl().selectAllUsers().forEach(System.out::println);
	}
	
	public static boolean UserLoginCheck(String name, String pass) {
		return new UserDaoImpl().selectAllUsers().stream()
								.anyMatch(o ->	o.getUserName().equals(name) 
											 && o.getUserPass().equals(pass));
	}
	
	public static Users setUser(String us, String ps) {
		return currentUser = new UserDaoImpl().selectUserByName(us, ps);
	}
	
	public static void userCheck() {
		System.out.println(currentUser.toString());
	}
	
	public static Users getUser() {
		return currentUser;
	}
	
	public static int UserType() {
		return currentUser.getUserID();
	}
	
	public static void printAllCustomers() {
		new CustomerDaoImpl().selectAllCustomers().forEach(System.out::println);
	}

	public static void listCustomers() {
		System.out.println("\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\tCUSTOMER KEY LIST");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("-----------------------------------");
		System.out.println("CID" + "\tFirst Name" + "\tLast Name");
		System.out.println("-----------------------------------");
		new CustomerDaoImpl().selectAllCustomers().forEach(System.out::println);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("To go back, simply enter \"b\"\n\n\n");
	}

	public static void viewUserAccounts() {
		// TODO Auto-generated method stub
		CustomerAccountDaoImpl aja = new CustomerAccountDaoImpl();
		listCustomers();
		System.out.print("Enter CID to get associated accounts:\t");
		
		while (!scani.hasNextInt()) {
			System.out.println("\n\n\tINVALID ENTRY! \n\tPlease try again...");
			System.out.print("Enter CID to get associated accounts:\t");
			scani.next();
		}
		
		int input = scani.nextInt();
		System.out.println("\n\n\n\n\nAccounts associated with ID #: " + input);
		System.out.println("-----------------------------------");
		System.out.println("Account ID" + "\tAccount Balance");
		System.out.println("-----------------------------------");
		aja.selectCustomerAccountByCID(input).forEach(System.out::println);
		
		scani.next();
	}

	public static void viewApplications() {
		// TODO Auto-generated method stub
		UserDaoImpl u = new UserDaoImpl();
		System.out.println(" UID" + "\tUserName\tPassword\tType");
		System.out.println("----------------------------------------------");

		u.selectAllUsers().stream()
						  .filter(x -> x.getAccountType()==999)
						  .forEach(System.out::println);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("To go back, simply enter \"b\"");
		System.out.print("Enter a  UID to approve an account:\t");
		
		int input = -1;
		if(scani.hasNextInt()) {
			input = scani.nextInt();
			Users thisOne = u.selectUserByID(input);
			Main.logger.info("Customer Approved!");
			Customer nc = new Customer(thisOne.getUserID(), thisOne.getUserName(), thisOne.getUserPass());
			new CustomerDaoImpl().insertCustomer(nc); //gets creataccount and account too		
		}
	}

	public static void withdrawFromCustomer() {
		// TODO Auto-generated method stub
		
	}

	public static void depositToCustomer() {
		// TODO Auto-generated method stub
		
	}

	public static void transferFromCustomer() {
		// TODO Auto-generated method stub
		
	}


	public static void listAllAcounts() {
		// TODO Auto-generated method stub
		System.out.println("\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\tANONYMIZED ACCOUNT LIST");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(" AID\t\tBalance");
		System.out.println("-----\t\t----------------");

		new AccountDaoImpl().selectAllAccounts().forEach(System.out::println);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.print("Enter any key to return to menu: \t");
	}

	public static void deleteUser() {
		// TODO Auto-generated method stub
//		while (!scani.hasNextInt()) {
//			if(scani.next() == "b")	return;
//			System.out.println("\n\n\tINVALID ENTRY! \n\tPlease try again...");
		
//			//scani.next();
//		}
		int UID = -1;
		viewUsers();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\nTo go back, simply enter \"b\"");
		System.out.print("Enter a  UID to delete an account:\t");	
		String input = scani.next();
		if(input.equals("b"))	return;
		else					UID = Integer.parseInt(input);
		
		UserDaoImpl kal = new UserDaoImpl();
		Users thisOne = kal.selectUserByID(UID);
		kal.deleteUser(thisOne);
	}
	


}
