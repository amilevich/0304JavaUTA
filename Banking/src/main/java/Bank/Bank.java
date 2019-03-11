package Bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	public static void main(String[] args) {

	}

	Map<String, User> UserMap = new HashMap<String, User>();
	public static HashMap<Integer, Account> AccountMap = new HashMap<Integer, Account>();
	Map<Integer, Account> AppMap = new HashMap<Integer, Account>();
	
	void employeegen(String username, String password, String first, String last) {
		UserMap.put(username, new Employee(username, password, first, last));
		}
		 
	void usergen(String username, String password, String first, String last) {
	UserMap.put(username, new Customer(username, password, first, last));
	}
	void accountgen(String username, double balance, double accountid) {
		 {
		}
			if (AccountMap.containsKey(accountid)){
				System.out.println("ID already exists");
				continue;
			}
			break;
	}
	 
}
