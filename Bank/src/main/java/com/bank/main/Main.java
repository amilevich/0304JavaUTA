package com.bank.main;

import java.util.Scanner;

//import com.bank.daoimpl.CustomerDaoImpl;
import com.bank.account.Account;
import com.bank.daoimpl.AdminDaoImpl;
import com.bank.users.Admin;
import com.bank.users.Customer;
import com.bank.utility.Util;

public class Main 
{
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Admin admin = new Admin();
		Util.refreshCustomers();
		Customer currCustomer = null;
		Util.printMain();
		int choice = Util.scanInt(scan);
		scan.nextLine();
		boolean quit = false;
		while (quit == false)
        {
			Util.refreshCustomers();
            switch (choice)
            {
                case 0:
                    Util.printMain();
                    choice = Util.scanInt(scan);
                    scan.nextLine();
                    break;

                case 1:
                    Customer newCust = new Customer();
                    Util.printEnter("Username");
                    newCust.setUserName(Util.scanString(scan));
                    Util.printEnter("Password");
                    newCust.setPassWord(Util.scanString(scan));
                    admin.addCustomer(newCust);
                    choice = 0;
                    break;

                case 2:
                    Util.printLogInUsername();
                    String username = Util.scanString(scan);

                    switch (username) {
                        case "admin":
                            Util.printLogInPassword();
                            String apassword = Util.scanString(scan);
                            int aChoice = 0;
                            int cmChoice = 0;
                            int eChoice = 0;
                            while (!apassword.equals("admin")) {
                                Util.printWrongPassword();
                                Util.printLogInPassword();
                                apassword = Util.scanString(scan);
                            }
                            Util.printAdminOptions();
                            
                            aChoice = Util.scanInt(scan);
                            scan.nextLine();
                            switch (aChoice)
                            {
                                case 1://1)Manage accounts
                                    Util.printAdminAccountOptions();
                                    int accOption = Util.scanInt(scan);
                                    scan.nextLine();
                                    switch (accOption) {
                                        case 1:
                                            admin.viewAllAccounts();
                                            break;

                                        case 2://2)Delete Accounts
                                            System.out.println("Enter account id to delete:");
                                            int beGoneAccount = Util.scanInt(scan);
                                            scan.nextLine();
                                            admin.deleteAccount(admin.getAccount(beGoneAccount));
                                            break;

                                        case 3://3)Approve/Deny Accounts
                                            for (int i = 0; i < admin.getPendingSize(); i++) {
                                                admin.getPendingAccount(i).printString();
                                                System.out.println("1)Approve");
                                                System.out.println("2)Deny");
                                                int approve = Util.scanInt(scan);
                                                scan.nextLine();
                                                if (approve == 1)
                                                    admin.Approve(admin.getPendingAccount(i));
                                                if (approve == 2)
                                                    admin.Deny(admin.getPendingAccount(i));
                                            }
                                            admin.clearPending();
                                            System.out.println("No more accounts pending");
                                            break;
                                        default:
                                            break;
                                    }
                                    
                                    break;

                                case 2://2)Manage customers
                                    Util.printAdminCustomerOptions();
                                    cmChoice = Util.scanInt(scan);
                                    scan.nextLine();
                                    switch (cmChoice) {
                                        case 1://1)View Customer
                                            Util.printEnter("Username: ");
                                            String searchName = Util.scanString(scan);
                                            if (searchName.equals(null))
                                                System.out.println("Customer not found");
                                            else Util.selectCustomer(searchName).printString();
                                            break;

                                        case 2://2)Delete Customer
                                            System.out.println("Enter customer Username: ");
                                            String deleteName = Util.scanString(scan);
                                            admin.deleteCustomer(Util.selectCustomer(deleteName));
                                            break;//</editor-fold>

                                        case 3://3)View All Customers
                                            Util.printCustomers();
                                            break;//</editor-fold>

                                        default:
                                            break;
                                    }
                                   
                                    break;

                                case 3:
                                    choice = 0;
                                    break;

                                default:
                                    break;
                            }
                            break;

                        case "employee":
                            Util.printLogInPassword();
                            String epassword = Util.scanString(scan);

                            while (!epassword.equals("employee")) {
                                System.out.println("Password doesn't match");
                                Util.printLogInPassword();
                                epassword = Util.scanString(scan);
                            }
                            Util.printEmployeeOptions();
                             eChoice = Util.scanInt(scan);
                            scan.nextLine();
                            switch (eChoice) {
                                case 1://1)Manage accounts
                                    Util.printEmployeeAccountOptions();
                                    int accOption = Util.scanInt(scan);
                                    scan.nextLine();
                                    switch (accOption) {
                                        case 1:
                                            admin.viewAllAccounts();
                                            break;

                                        case 2://2)Approve/Deny Accounts
                                            for (int i = 0; i < admin.getPendingSize(); i++) {
                                                admin.getPendingAccount(i).printString();
                                                System.out.println("1)Approve");
                                                System.out.println("2)Deny");
                                                int approve = Util.scanInt(scan);
                                                scan.nextLine();
                                                if (approve == 1)
                                                    admin.Approve(admin.getPendingAccount(i));
                                                if (approve == 2)
                                                    admin.Deny(admin.getPendingAccount(i));
                                            }
                                            admin.clearPending();
                                            System.out.println("No more accounts pending");
                                            break;
                                        default:
                                            break;
                                    }
                                    break;

                                case 2://2)Manage customers
                                    Util.printAdminCustomerOptions();
                                    cmChoice = Util.scanInt(scan);
                                    scan.nextLine();
                                    switch (cmChoice) {
                                        case 1://1)View Customer
                                            Util.printEnter("Username: ");
                                            String searchName = Util.scanString(scan);
                                            if (searchName.equals(null))
                                                System.out.println("Customer not found");
                                            else Util.selectCustomer(searchName).printString();
                                            break;

                                        case 2://2)View All Customers
                                            Util.printCustomers();
                                            break;

                                        default:
                                            break;
                                    }
                                    break;

                                case 3:
                                    choice = 0;
                                    break;

                                default:
                                    break;
                            }
                            choice = 0;
                            break;

                        default://customer
                            currCustomer =(new AdminDaoImpl()).selectCustomer(username);
                            if (currCustomer == null)
                                break;
                            Util.printLogInPassword();
                            String currPassword = Util.scanString(scan);

                            while (!currPassword.equals(currCustomer.getPassWord())) {
                                System.out.println("Password doesn't match");
                                Util.printLogInPassword();
                                currPassword = Util.scanString(scan);
                            }
                            Util.printCustomerOptions();
                           cmChoice = Util.scanInt(scan);
                            scan.nextLine();
                            switch (cmChoice) {
                                case 1://view info
                                    currCustomer.printString();
                                    break;

                                case 2://2)Manage accounts
                                    Util.printCustomerAccountOptions();
                                    int accOption = Util.scanInt(scan);
                                    scan.nextLine();
                                    Account currAccount = null;
                                    double currAmount = 0.0;
                                    switch (accOption) {

                                        case 1:
                                        	currCustomer.printString();
                                        	currAccount = admin.getAccount(currCustomer.getMainAccountID());
                                        	if (currAccount == null) {
                                                System.out.println("No accounts found");
                                                break;
                                            }
                                        	currAccount.printString();
                                            break;

                                        case 2:
                                            currAccount = admin.getAccount(currCustomer.getMainAccountID());
                                            if (currAccount == null) {
                                                System.out.println("No accounts found");
                                                break;
                                            }
                                            Util.printEnter("amount to withdraw");
                                            currAmount = Util.scanFloat(scan);
                                            scan.nextLine();
                                            admin.accountWithdraw(currAccount, currAmount);
                                            System.out.println("New balance: " + admin.getAccount(currCustomer.getMainAccountID()).getBalance());
                                            break;

                                        case 3:
                                            currAccount = admin.getAccount(currCustomer.getMainAccountID());
                                            if (currAccount == null) {
                                                System.out.println("No accounts found");
                                                break;
                                            }
                                            Util.printEnter("amount to deposit");
                                            currAmount = Util.scanFloat(scan);
                                            scan.nextLine();
                                            admin.accountDeposit(currAccount, currAmount);
                                            System.out.println("New balance: " + admin.getAccount(currCustomer.getMainAccountID()).getBalance());
                                            break;
                                        default:
                                            break;
                                    }
                                    
                                    break;

                                case 3:
                                    admin.addPendingAccount( new Account(currCustomer.getMainAccountID(),0.0,currCustomer.getId(),0));
                                   
                                    System.out.println("Account pending approval");
                                    break;

                                default:
                                    break;
                            }
                            
                            break;
                    }
                    choice = 0;
                    break;

                case 3:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
	}
}
