package com.bank.daoJunctionTable;

import java.util.List;

import com.bank.model.Junction;
import com.bank.model.UserAccount;

public interface DaoJunction {

	public Junction getJunctionByUserId(int userid);

	public Junction getJunctionByAccountId(int accountid);

	public int insertJunction(Junction j);

	public List<UserAccount> getUserAccountsByUserName(String userName);

	public List<UserAccount> getAllUserAccounts();
}
