package Bank;

import java.util.HashSet;
import java.util.Set;

public class Account {
	
	int accountid;
	double balance;
	HashSet<String> accountholders = new HashSet<String>();
	public Account(int accountid, double balance, String accountholder) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.accountholders.add(accountholder);
	}
	
	

}
