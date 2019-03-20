package com.bank.users;

import com.bank.account.Account;
import com.bank.daoimpl.EmployeeDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class Employee
{
    private ArrayList<Account> pending = new ArrayList<>();
    public EmployeeDaoImpl edi = new EmployeeDaoImpl();


    public void clearPending(){pending.clear();}
    public int getPendingSize() {return pending.size();}

    public Account getPendingAccount(int i) {return pending.get(i);}

    public void Approve(Account account){edi.insertAccount(account);}

    public void Deny(Account account)
    {
        for (int i = 0; i < pending.size(); i++)
        {
            if (pending.get(i).getId() == account.getId())
                pending.remove(i);
        }
    }

    public Account getAccount(int id) {return edi.selectAccount(id);}
    public Customer getCustomer(int id) {return edi.selectCustomer(id);}
    public void viewAllAccounts()
    {
        List<Account> accounts = edi.selectAllAccounts();
        for (int i = 0; i < accounts.size(); i++)
        {
            accounts.get(i).toString();
        }
    }
    public void viewAllCustomers()
    {
        List<Customer> customers = edi.selectAllCustomers();
        for (int i = 0; i < customers.size(); i++)
        {
            customers.get(i).toString();
        }
    }

}
