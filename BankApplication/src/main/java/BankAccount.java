
public class BankAccount extends Customer implements Transactions{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double balance;
	private String accountHolders;
	
	
	
	public BankAccount(String fName, String lName, String userName, String password, double balance, String accountHolders) {
		super(fName, lName, userName, password);
		this.balance = balance;
		this.accountHolders = accountHolders;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public String getAccountHolders() {
		return accountHolders;
	}
	
	
	public void setAccountHolders(String accountHolders) {
		this.accountHolders = accountHolders;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((accountHolders == null) ? 0 : accountHolders.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountHolders == null) {
			if (other.accountHolders != null)
				return false;
		} else if (!accountHolders.equals(other.accountHolders))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	
	@Override
	public boolean deposit(double amount) {
		if(amount < 0) {
			return false;
		}else {
			balance = balance + amount;
			return true;
		}
	}


	@Override
	public boolean withdraw(double amount) {
		if(amount > balance) {
			return false;
		}else if(amount < 0){
		return false;
		}else {
			balance = balance - amount; 
			return true;
		}
	}


	@Override
	public boolean transferTo(String userName, double amount) {
		BankAccount to;
		
		if(loginStuff.get(userName) instanceof BankAccount) {
			to = (BankAccount) loginStuff.get(userName);
			
			return withdraw(amount) && to.deposit(amount);
		}else {
		return false;} 
	}
	

}
