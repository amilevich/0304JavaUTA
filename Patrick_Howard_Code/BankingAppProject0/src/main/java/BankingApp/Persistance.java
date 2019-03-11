package BankingApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Persistance {

	public void storeUsers(List<User> users) {

		OutputStream ops = null;
		ObjectOutputStream objOps = null;
		try {
			ops = new FileOutputStream("BankingUsers.txt");
			objOps = new ObjectOutputStream(ops);

			objOps.writeObject(users);
			objOps.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (objOps != null)
					objOps.close();
			} catch (Exception ex) {

			}
		}

	}

	public void storeAccounts(List<Account> accounts) {

		OutputStream ops = null;
		ObjectOutputStream objOps = null;
		try {
			ops = new FileOutputStream("BankingAccounts.txt");
			objOps = new ObjectOutputStream(ops);
			objOps.writeObject(accounts);
			objOps.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (objOps != null)
					objOps.close();
			} catch (Exception ex) {

			}
		}

	}

	public List<User> retrieveUsers() {

		InputStream fileIs = null;
		ObjectInputStream objIs = null;

		List<User> users = new ArrayList<User>();

		try {
			fileIs = new FileInputStream("BankingUsers.txt");
			objIs = new ObjectInputStream(fileIs);
			users = (List<User>) objIs.readObject();

		} catch (FileNotFoundException e) {
			// return empty object
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		} finally {
			try {
				if (objIs != null)
					objIs.close();
			} catch (Exception ex) {

			}
		}
		return users;
	}

	public List<Account> retrieveAccounts() {

		InputStream fileIs = null;
		ObjectInputStream objIs = null;

		List<Account> accounts = new ArrayList<Account>();

		try {
			fileIs = new FileInputStream("BankingAccounts.txt");
			objIs = new ObjectInputStream(fileIs);
			accounts = (List<Account>) objIs.readObject();

		} catch (FileNotFoundException e) {
			// return empty object
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		} finally {
			try {
				if (objIs != null)
					objIs.close();
			} catch (Exception ex) {

			}
		}
		return accounts;
	}

}
