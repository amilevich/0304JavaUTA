package bankingapp;

public class MoneyTable {

	int customerIndex;
	String customerUsername;
	double customerMoney;

	public MoneyTable() { //constructor
	}

	public String getName() {
		return customerUsername;
	}

	public void setName(String name) {
		this.customerUsername = name;
	}

	public double getMoney() {
		return customerMoney;
	}

	public void setMoney(double money) {
		this.customerMoney = money;
	}

	@Override
	public String toString() {
		return "Customer [Index=" + customerIndex +", Username=" + customerUsername + ", Money=" + customerMoney + "]";
	}

	public MoneyTable(int index, String name, double money) { //constructor, overload
		super();
		this.customerIndex = index;
		this.customerUsername = name;
		this.customerMoney = money;
	}

	public int getIndex() { //I added these two methods
		return customerIndex;
	}
	
	public void setIndex(int index) {
		this.customerIndex = index;
	}

}
