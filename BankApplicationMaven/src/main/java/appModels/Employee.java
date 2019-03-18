package appModels;

import java.util.List;

public class Employee implements AllUsers,ConsumerAndAdmin {

	/*
	 * This is the Employee Bean, it contains the Username, password, and
	 * 	admin privileges modifier
	 */
	
	
	String Username;
	int password;
	int admin_privileges;
	
	
	
	public Employee(String username, int password, int admin_privileges) {
		super();
		Username = username;
		this.password = password;
		this.admin_privileges = admin_privileges;
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

	public int getAdmin_privileges() {
		return admin_privileges;
	}

	public void setAdmin_privileges(int admin_privileges) {
		this.admin_privileges = admin_privileges;
	}

	@Override
	public String toString() {
		return "Employee [Username=" + Username + ", password=" + password + ", admin_privileges=" + admin_privileges
				+ "]";
	}

	@Override
	public void Login(String UserN, int PassW) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Logout() {
		//conn.commit();
		
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
	
	public void deleteAccountPriv(int admin_privileges) {
		
	}

}
