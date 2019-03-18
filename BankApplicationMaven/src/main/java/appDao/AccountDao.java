package appDao;

import java.util.ArrayList;

import appModels.Accounts;
import appModels.Customer;
import appModels.Employee;

public interface AccountDao {

	public int insertAccount(Accounts A);
	
	public Accounts selectOneCustAccount(int A);
	
	public ArrayList<Accounts> selectCustAccounts(String Username1);
	
	public ArrayList<Accounts> selectAllAccounts();
	
	public int updateAccount(Accounts A);
	public int Withdraw (Accounts A,int request, Customer C);
	public int Withdraw (Accounts A,int request, String UserName);
	public int Deposit (Accounts A, int request, Customer C);
	public int Deposit (Accounts A, int request, String UserName);
	public int Transfer (Accounts A, Accounts B, int request);
	public int AutoApproveDeny(Customer C);
	
	public int deleteAccount(Accounts A, Employee E);
	
	//int nextSequence();
}
