package appModels;

import java.util.List;

public class Customer implements ConsumerAndAdmin {

	String Username;
	int password;
	int creditscore;
	int account_tracker;
	
	
	
	public Customer(String username, int password, int creditscore, int account_tracker) {
		super();
		Username = username;
		this.password = password;
		this.creditscore = creditscore;
		this.account_tracker = account_tracker;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getCreditscore() {
		return creditscore;
	}

	public void setCreditscore(int creditscore) {
		this.creditscore = creditscore;
	}

	public int getAccount_tracker() {
		return account_tracker;
	}

	public void setAccount_tracker(int account_tracker) {
		this.account_tracker = account_tracker;
	}
	
	
	

	@Override
	public String toString() {
		return "Customer [Username=" + Username + ", password=" + password + ", creditscore=" + creditscore
				+ ", account_tracker=" + account_tracker + "]";
	}

	@Override
	public void Login(String UserN, int PassW) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deposit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Transfer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Withdraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Accounts> ViewAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Accounts createAccount() {
		
		return null;
	}

}
