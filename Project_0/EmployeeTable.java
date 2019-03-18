package bankingapp;

public class EmployeeTable {

	int employeeIndex;
	String employeeUsername, employeePassword;

	public EmployeeTable() { //constructor
	}

	public String getName() {
		return employeeUsername;
	}

	public void setName(String name) {
		this.employeeUsername = name;
	}

	public String getPassword() {
		return employeePassword;
	}

	public void setPassword(String password) {
		this.employeePassword = password;
	}

	@Override
	public String toString() {
		return "Employee [Index=" + employeeIndex +", Username=" + employeeUsername + ", Password=" + employeePassword + "]";
	}

	public EmployeeTable(int index, String name, String password) { //constructor, overload
		super();
		this.employeeIndex = index;
		this.employeeUsername = name;
		this.employeePassword = password;
	}

	public int getIndex() { //I added these two methods
		return employeeIndex;
	}
	
	public void setIndex(int index) {
		this.employeeIndex = index;
	}

}
