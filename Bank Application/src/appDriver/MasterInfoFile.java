package appDriver;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import Users.Employees;
import Users2.Customers;
import accountObjects.AccountObject;
import accountObjects.JointAccount;

public class MasterInfoFile implements Serializable {
	
/** 
	 * 
	 */
	/*
	 * This is the master list of customers, employees, and accounts
	 */
	private static final long serialVersionUID = 3L;

//static String filename = "./MasterInfoFile.txt";
	
	//Hashmap used to store customers with their accounts
public static Map<Customers,AccountObject> map = new HashMap<Customers,AccountObject>();
public static Map<Customers,JointAccount> jmap = new HashMap<Customers,JointAccount>();

	//ArrayList to hold the different customers and employees
public static ArrayList<Customers> cust = new ArrayList<Customers>();
public static ArrayList<Employees> emp = new ArrayList<Employees>();

	//Queue of customer accounts awaiting approval by employees/admins
public static Queue<AccountObject> que = new LinkedList<AccountObject>();
public static Queue<JointAccount> qu = new LinkedList<JointAccount>();
	
public MasterInfoFile() {}



//public MasterInfoFile(Map<Customers, AccountObject> map, Map<Customers, JointAccount> jmap, ArrayList<Customers> cust,
//		ArrayList<Employees> emp, Queue<AccountObject> que, Queue<JointAccount> qu) {
//	this.map = map;
//	this.jmap = jmap;
//	this.cust = cust;
//	this.emp = emp;
//	this.que = que;
//	this.qu = qu;
//}



public Map<Customers, AccountObject> getMap() {
	return map;
}

public void setMap(Map<Customers, AccountObject> map) {
	MasterInfoFile.map = map;
}

public Map<Customers, JointAccount> getJmap() {
	return jmap;
}

public void setJmap(Map<Customers, JointAccount> jmap) {
	MasterInfoFile.jmap = jmap;
}

public ArrayList<Customers> getCust() {
	return cust;
}

public void setCust(ArrayList<Customers> cust) {
	MasterInfoFile.cust = cust;
}

public ArrayList<Employees> getEmp() {
	return emp;
}

public void setEmp(ArrayList<Employees> emp) {
	MasterInfoFile.emp = emp;
}

public Queue<AccountObject> getQue() {
	return que;
}

public void setQue(Queue<AccountObject> que) {
	MasterInfoFile.que = que;
}

public Queue<JointAccount> getQu() {
	return qu;
}

public void setQu(Queue<JointAccount> qu) {
	MasterInfoFile.qu = qu;
}
	


}
