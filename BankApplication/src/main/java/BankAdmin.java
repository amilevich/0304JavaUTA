
public class BankAdmin extends Employee{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAdmin(String fname, String lname, String userName, String password) {
		super(fname, lname, userName, password);
		// TODO Auto-generated constructor stub
	}

	
	public static boolean  cancelAccount(BankAccount account) {
		if(loginStuff.containsKey(account.getUserName())) {
			loginStuff.remove(account.getUserName());
			return true;
		}else {
			return false; 
		}
	}
	
	public static boolean reviewAccount(BankAccount account) {
		
		return true;
	}
	
	public static boolean withdraw(BankAccount account, double amount) {
		return account.withdraw(amount); 
	}
	
	public static boolean deposit(BankAccount account, double amount) {
		return account.deposit(amount);
	}
	
	public static boolean transferTo(BankAccount from, String to, double amount) {
		return from.transferTo(to, amount);
	}
}
