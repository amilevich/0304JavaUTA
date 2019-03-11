package accountObjects;

public class AccountParent {

	public int accnum;
	public int routingnum;
	
	public int accountState = 0;
	
	//account account name
	public String account;

		
	//balance
	public float balance = 0;
	
	
	public AccountParent(String account) {
		this.account = account;
	}

	
	public int getAccnum() {
		return accnum;
	}

	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}


	public int getRoutingnum() {
		return routingnum;
	}



	public void setRoutingnum(int routingnum) {
		this.routingnum = routingnum;
	}



	public int getAccountState() {
		return accountState;
	}



	public void setAccountState(int accountState) {
		this.accountState = accountState;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public float getBalance() {
		return balance;
	}



	public void setBalance(float balance) {
		this.balance = balance;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accnum;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + accountState;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + routingnum;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountParent other = (AccountParent) obj;
		if (accnum != other.accnum)
			return false;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (accountState != other.accountState)
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (routingnum != other.routingnum)
			return false;
		return true;
	}
	


		
}
