package bankingapp;

public class CustomerTable {

	int customerIndex;
	String customerUsername, customerPassword;

	public CustomerTable() { //constructor
	}

	public String getName() {
		return customerUsername;
	}

	public void setName(String name) {
		this.customerUsername = name;
	}

	public String getPassword() {
		return customerPassword;
	}

	public void setPassword(String password) {
		this.customerPassword = password;
	}

	@Override
	public String toString() {
		return "Customer [Index=" + customerIndex +", Username=" + customerUsername + ", Password=" + customerPassword + "]";
	}

	public CustomerTable(int index, String name, String password) { //constructor, overload
		super();
		this.customerIndex = index;
		this.customerUsername = name;
		this.customerPassword = password;
	}

	public int getIndex() { //I added these two methods
		return customerIndex;
	}
	
	public void setIndex(int index) {
		this.customerIndex = index;
	}

}
