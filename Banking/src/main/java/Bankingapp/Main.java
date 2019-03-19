package Bankingapp;

import java.util.Scanner;

import com.models.beans.Account;
import com.models.beans.Customer;
import com.project.dao.AccountDaoImpl;
import com.project.dao.CustomerDaoImpl;

import oracle.net.aso.c;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		{

			while (true) {

				System.out.println("Welcome to the International Bank of Yousef");
				System.out.println("Please select from the following: ");
				System.out.println("1.Login");
				System.out.println("2.Register");

				switch (scanner.nextInt()) {

				case 1:
					String l = "Yousef";
					String k = "Admin";
					System.out.println("Enter Username: ");
					String u = scanner.next();
					System.out.println("Password: ");
					String p = scanner.next();
					CustomerDaoImpl newlog = new CustomerDaoImpl();
					newlog.selectByUsername(u);
					for (Customer logcust : newlog.selectAllCustomer())
						if (u.equals(l) && p.equals(k)) {
							adminmenu(logcust);
							break;
						} else if (logcust.getUsername().equals(u) && logcust.getPassword().equals(p)) {
							
							{

								System.out.println("logged in");
								System.out.println("Make selection");
								System.out.println("1. Deposit");
								System.out.println("2. Withdraw");
								System.out.println("3. Transfer");
								System.out.println("4. View Balance");
								System.out.println("5. Logout");

								while (true) {
									boolean logout = false;
									switch (scanner.nextInt()) {

									case 1:
										System.out.println("Enter Amount to Deposit: ");
										Double d = scanner.nextDouble();
										Account depo = new Account();
										AccountDaoImpl depositimp = new AccountDaoImpl();
										depo = depositimp.selectByUsername(logcust.getUsername());
										d = depo.getBalance() + d;
										depo.setBalance(d);
										depositimp.updateAccount(depo);

										break;

									case 2:

										System.out.println("Enter Amount to Withdraw: ");
										Double w = scanner.nextDouble();
										Account witho = new Account();
										AccountDaoImpl withimp = new AccountDaoImpl();
										witho = withimp.selectByUsername(logcust.getUsername());
										w = witho.getBalance() - w;
										witho.setBalance(w);
										withimp.updateAccount(witho);

										break;

									case 3:

										System.out.println("Enter Transfer Amount ");
										Double t = scanner.nextDouble();
										Double bal = null;
										Account transfo = new Account();
										AccountDaoImpl trimpy = new AccountDaoImpl();
										transfo = trimpy.selectByUsername(logcust.getUsername());
										System.out.println("Enter username of recipient: ");
										String r = scanner.next();
										Account transfee = new Account();
										transfee = trimpy.selectByUsername(r);
										bal = transfo.getBalance() - t;
										transfo.setBalance(bal);
										trimpy.updateAccount(transfo);
										bal = transfee.getBalance() + t;
										transfee.setBalance(bal);
										trimpy.updateAccount(transfee);

										break;

									case 4:
										AccountDaoImpl viewo = new AccountDaoImpl();
										Account viewy = new Account();
										viewy = viewo.selectByUsername(logcust.getUsername());
										System.out.println("Balance = " + viewy.getBalance());
										System.out.println("Account user = " + viewy.getUsername());
										System.out.println("Account Verification Status: " + viewy.isStatus());

										break;

									case 5:
										logout = true;
									}
									if (logout)
										break;

								}
							}

							break;
						}
					break;
				case 2:

					Customer customer = new Customer();
					System.out.println("Create username: ");
					String x = scanner.next();
					customer.setUsername(x);
					System.out.println("Create password: ");
					String y = scanner.next();
					customer.setPassword(y);
					CustomerDaoImpl newcusto = new CustomerDaoImpl();
					newcusto.insertCustomer(customer);
					Account account = new Account();
					double b = 0;
					boolean q = false;
					account.setUsername(x);
					account.setBalance(b);
					account.setStatus(q);
					AccountDaoImpl newacc = new AccountDaoImpl();
					newacc.insertAccount(account);

					System.out.println("Registration Complete");

					break;

				}

			}
		}
	}

	public static void adminmenu(Customer logcust) {
		
		System.out.println("Please select from the following: ");
		System.out.println("1. View Account by Username");
		System.out.println("2. Delete Account by Username");
		System.out.println("3. Approve Account");
		System.out.println("4. Return to Login");
		switch (scanner.nextInt()) {

		case 1:
			System.out.println("EnterUser: ");
			String apin = scanner.next();
			AccountDaoImpl apcusv = new AccountDaoImpl();
			Account apcust = new Account();
			apcust = apcusv.selectByUsername(apin);
			System.out.println("Balance = " + apcust.getBalance());
			System.out.println("Account user = " + apcust.getUsername());
			System.out.println("Account Verification Status: " + apcust.isStatus());

			break;

		case 2:
			System.out.println("EnterUser: ");
			String delo = scanner.next();
			Account delee = new Account();
			AccountDaoImpl deleto = new AccountDaoImpl();
			Customer delcust = new Customer();
			CustomerDaoImpl delcusto = new CustomerDaoImpl();
			delee = deleto.selectByUsername(delo);
			deleto.deleteAccount(delee);
			deleto.updateAccount(delee);
			delcust = delcusto.selectByUsername(delo);
			delcusto.deleteCustomer(delcust);
			delcusto.updateCustomer(delcust);

			break;

		case 3:
			System.out.println("Enter Account to Approve: ");
			String approv = scanner.next();
			Account approvo = new Account();
			AccountDaoImpl approvee = new AccountDaoImpl();
			approvo = approvee.selectByUsername(approv);
			approvo.setStatus(true);
			approvee.updateAccount(approvo);

			break;
			
			
				
		}
			
	}
}
