package com.projectone.driver;

import java.sql.Blob;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.projectone.dao.ReimbursementDaoImpl;
import com.projectone.dao.ReimbursementStatusDaoImpl;
import com.projectone.dao.ReimbursementTypeDaoImpl;
import com.projectone.dao.UserRolesDaoImpl;
import com.projectone.dao.UsersDaoImpl;
import com.projectone.models.Reimbursement;
import com.projectone.models.ReimbursementStatus;
import com.projectone.models.ReimbursementType;
import com.projectone.models.UserRoles;
import com.projectone.models.Users;

public class Main {
	
	static UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
	static UserRolesDaoImpl userRolesDaoImpl = new UserRolesDaoImpl();
	static ReimbursementTypeDaoImpl reimbursementTypeDaoImpl = new ReimbursementTypeDaoImpl();
	static ReimbursementStatusDaoImpl reimbursementStatusDaoImpl = new ReimbursementStatusDaoImpl();
	static ReimbursementDaoImpl reimbursementDaoImpl = new ReimbursementDaoImpl();
	
	public static void main(String[] args) {

		/*System.out.println("checkpoint1");
		UserRoles userRoles = new UserRoles("Viking");
		userRolesDaoImpl.insertUserRole(userRoles);
		System.out.println("UserRoles successful");*/
		
		/*System.out.println("checkpoint2");
		Users user = new Users("Ragnar_Lothbrok", "password", "Ragnar", "Lothbrok", "ragnar@gmail.com", 1);
		usersDaoImpl.insertUser(user);
		System.out.println("Users successful");*/
		/*System.out.println("New User");
		Users user1 = new Users("Ivar_Lothbrok", "pass", "Ivar", "Lothbrok", "ivar@gmail.com", 1);
		usersDaoImpl.insertUser(user1);
		System.out.println("New User Added");*/
		/*System.out.println("New User");
		Users user2 = new Users("Bjorn_Lothbrok", "bl1", "Bjorn", "Lothbrok", "bjorn@gmail.com", 1);
		usersDaoImpl.insertUser(user2);
		System.out.println("New User Added");*/
		/*System.out.println("Select User");
		Users user3 = new Users();
		user3 = usersDaoImpl.selectUserByName("Bjorn_Lothbrok", "bl1");
		System.out.println(user3);
		System.out.println("User username: "+user3.getErsUsername());
		System.out.println("User password: "+user3.getErsPassword());
		System.out.println("User email: "+user3.getUserEmail());
		System.out.println("User firstName: "+user3.getUserFirstName());
		System.out.println("User lastName"+user3.getUserLastName());
		System.out.println("User userID"+user3.getErsUsersId());*/
		
		/*System.out.println("checkpoint3"); 
		ReimbursementType reimbursementType = new ReimbursementType("Active");
		reimbursementTypeDaoImpl.insertReimbursementType(reimbursementType);
		System.out.println("ReimbursementType success");*/
		
		/*System.out.println("checkpoint4");
		ReimbursementStatus reimbursementStatus = new ReimbursementStatus("Denied");
		reimbursementStatusDaoImpl.insertReimbursementStatus(reimbursementStatus);
		System.out.println("ReimbursementStatus success");*/
		/*ReimbursementStatus reimbursementStatus = new ReimbursementStatus();
		reimbursementStatus.setReimbStatus("Approved");
		reimbursementStatus.setReimbStatusId(22);
		reimbursementStatusDaoImpl.updateReimbursementStatus(reimbursementStatus.getReimbStatus(), reimbursementStatus.getReimbStatusId());
		System.out.println("Should have updated");*/
		
		//Blob y = new Blob();
		/*Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		System.out.println("Timestamp: "+ts);
		Timestamp ts1 = new Timestamp(time);
		System.out.println("Timestamp 1 :"+ts1);
		String x = "Description";
		System.out.println("checkpoint5");
		Reimbursement reimbursement = new Reimbursement(100.00, ts, ts1, "Description", null, 1, 1, 1, 1);
		reimbursementDaoImpl.insertReimbursement(reimbursement);
		System.out.println("Reimbursement ");*/
		
		System.out.println(getTime());
		reimbursementDaoImpl.updateReimbursement(getTime(), 23);
		
	}
	
	public static Timestamp getTime() {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts;
	}

}
