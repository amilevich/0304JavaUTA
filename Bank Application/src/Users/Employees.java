package Users;

public class Employees implements BankExclusive{

public String UserN;
public int password;
	
	public Employees (String UserN, int PassW) 
	{
		this.UserN = UserN;
		this.password = PassW;
	}
	
	@Override
	public void Logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Login(String UserN, int PassW) {
		// TODO Auto-generated method stub
		
	}
	
	public void CheckQue() 
	{
		
	}
	
	public void SeeAccounts() {}

	@Override
	public int changeAcctState() { //EMPLOYEES/ADMINS approve accounts in que by
		return 0;				//changing employee account state variable from 
	}						// 0(suspending) to 1 (approved) or -1 (denied)
	

}
