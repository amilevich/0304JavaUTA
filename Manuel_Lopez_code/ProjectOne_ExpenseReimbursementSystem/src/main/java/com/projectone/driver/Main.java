package com.projectone.driver;

import com.projectone.dao.ReimbursementStatusDaoImpl;
import com.projectone.dao.ReimbursementTypeDaoImpl;
import com.projectone.dao.UserRolesDaoImpl;
import com.projectone.dao.UsersDaoImpl;
import com.projectone.models.ReimbursementStatus;
import com.projectone.models.ReimbursementType;
import com.projectone.models.UserRoles;
import com.projectone.models.Users;

public class Main {
	
	static UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
	static UserRolesDaoImpl userRolesDaoImpl = new UserRolesDaoImpl();
	static ReimbursementTypeDaoImpl reimbursementTypeDaoImpl = new ReimbursementTypeDaoImpl();
	static ReimbursementStatusDaoImpl reimbursementStatusDaoImpl = new ReimbursementStatusDaoImpl();
	
	public static void main(String[] args) {

		/*System.out.println("checkpoint1");
		UserRoles userRoles = new UserRoles(1, "Viking");
		userRolesDaoImpl.insertUserRole(userRoles);
		System.out.println("UserRoles successful");*/
		
		/*System.out.println("checkpoint2");
		Users user = new Users(1, "Ragnar_Lothbrok", "password", "Ragnar", "Lothbrok", "ragnar@gmail.com", 1);
		usersDaoImpl.insertUser(user);
		System.out.println("Users successful");*/
		
		/*System.out.println("checkpoint3");
		ReimbursementType reimbursementType = new ReimbursementType(2, "Active");
		ReimbursementType reimbursementType1 = new ReimbursementType();
		reimbursementTypeDaoImpl.insertReimbursementType(reimbursementType);
		reimbursementTypeDaoImpl.selectReimbursementTypeByName(reimbursementType.getReimbTypeId());
		System.out.println(reimbursementType1);
		System.out.println("ReimbursementType success");*/
		
		/*System.out.println("checkpoint4");
		ReimbursementStatus reimbursementStatus = new ReimbursementStatus(1, "Approved");
		reimbursementStatusDaoImpl.insertReimbursementStatus(reimbursementStatus);
		System.out.println("ReimbursementStatus success");*/
		
		System.out.println("checkpoint5");
	}

}
