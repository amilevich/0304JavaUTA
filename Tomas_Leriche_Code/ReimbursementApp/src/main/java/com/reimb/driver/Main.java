package com.reimb.driver;

import java.util.List;

import org.apache.log4j.Logger;

import com.reimb.dao.ReimbursementDaoImpl;
import com.reimb.dao.UsersDaoImpl;
import com.reimb.model.Reimbursement;
import com.reimb.model.Users;

public class Main {

	
	final static Logger logger = Logger.getLogger(Main.class);
	
	
	public static void main(String[] args) {
		logger.info("Main.java started running.\n");
		
		System.out.println("Application Started...");
		
		UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
		ReimbursementDaoImpl reimbursementDaoImpl = new ReimbursementDaoImpl();
		
		List<Users> users = usersDaoImpl.selectAllUsers();
		List<Reimbursement> reimbursements = reimbursementDaoImpl.selectAllReimbursement();
		
		Users user1 = usersDaoImpl.selectUserById(2);
		
		printArrayUsers(user1);
		printArrayUsers(users);
		printArrayReimbursements(reimbursements);
	}
	
	public static void printArrayUsers(Users elem) {
		System.out.println("User List:");
		System.out.println("----------");
		System.out.println("|   User ID   |    Username   |    Password  |      Role      |       Full Name      |         Email          |"
				+ "  \n|---------------------------------------------------------------------------------------------------------");

		System.out.println("| \t" + elem.getUser_id() + "\t " + elem.getUser_name() + "\t  " + elem.getUser_password()
						+ "\t\t" + elem.getUser_role() + "\t" + elem.getUser_first_name() + " " + elem.getUser_last_name() 
						+ "\t\t " + elem.getUser_email() );

		System.out.println("|---------------------------------------------------------------------------------------------------------");
	}
	
	public static void printArrayUsers(List<Users> u) {
		System.out.println("User:");
		System.out.println("-----");
		System.out.println("|   User ID   |    Username   |    Password  |      Role      |       Full Name      |          Email         |"
				+ "  \n|----------------------------------------------------------------------------------------------------------");
		for (Users elem : u) {
			
			System.out.println("| \t" + elem.getUser_id() + "\t " + elem.getUser_name() + "\t  " + elem.getUser_password()
			+ "\t\t" + elem.getUser_role() + "\t" + elem.getUser_first_name() + " " + elem.getUser_last_name() 
							+ "\t\t " + elem.getUser_email() );

			System.out.println("|-------------------------------------------------------------------------------------------------------------");

		}
	}
	
	public static void printArrayReimbursements(List<Reimbursement> r) {
		System.out.println("Reimbursement List:");
		System.out.println("-------------------");
		System.out.println("|   Reimb ID   |      Amount     |                         Description                           | "
				+ "  \n|----------------------------------------------------------------------------------------------------------");
		
		for (Reimbursement elem : r) {
			
			System.out.println("| \t" + elem.getReimbId() + "\t   " + elem.getReimbAmount() + "\t\t  " + elem.getReimbDescription()
			+ "\t\t");

			System.out.println("|-------------------------------------------------------------------------------------------------------------");

		}
	}
}
