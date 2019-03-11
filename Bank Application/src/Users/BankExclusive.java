package Users;

interface BankExclusive extends AllUsers {
	
	
	int changeAcctState();
	
	
	void Login(String UserN, int PassW);
	void Logout();
	
	
	//only Employees and admins can approve or deny applications


}
