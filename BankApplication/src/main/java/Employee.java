
public class Employee extends Customer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Employee(String fname, String lname, String userName, String password) {
		super(fname, lname, userName, password);
		// TODO Auto-generated constructor stub
	}

	public static boolean reviewAccount(BankAccount account) {
		
		return true;
	}
	
	public static double viewBalance(BankAccount account) {
		return account.getBalance();
	}
	
	public static String accountInfo(BankAccount account) {
		String ai = account.toString();
				return ai;
	}

}
