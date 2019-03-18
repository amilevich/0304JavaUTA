package appDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import appModels.Customer;

public class CustomerDaoImple implements CustomerDao {

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cmseb0jui8wp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "AlimWooden";
	private static String password = "Donkey123";
	
	Logger Log = Logger.getGlobal();
	
	//create in java editor
	@Override
	public int insertCustomer(Customer C) {//passes in Object type to access its getters for the query performed //COMMITS at end
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			Log.info("Customer insert query attempted");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO bank_Customers VALUES(?,?,?,?)");//NUMBER OF QUESTION MARKS CORRESPOND TO TABLE COLUMNS
					ps.setString(1, C.getUsername());
					ps.setInt(2, C.getPassword());
					ps.setInt(3, C.getCreditscore());
					ps.setInt(4, C.getAccount_tracker());
					ps.executeQuery();
					Log.info("Completed customer insert query");
					
		}
		catch(SQLException e){e.printStackTrace(); Log.warning("Customer Request couldn't connect");}
		
		return 0;//for debugging purposes
	}
	
	
	@Override
	public Customer getCustomerByUsername(String username1) {
		Customer C = null;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_Customers WHERE Username=?");
			ps.setString(1, username1);//expected input for query
			ResultSet rs = ps.executeQuery();		
			while(rs.next()) {
				C = new Customer(rs.getString("Username"),rs.getInt("Password"),rs.getInt("credit_Score"),rs.getInt("account_Tracker"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return C;
	}
	
	
	@Override
	public ArrayList<Customer> CustomerArchive() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_Customers");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customers.add(new Customer(rs.getString("Username"),rs.getInt("Password"),rs.getInt("credit_Score"),rs.getInt("account_Tracker")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return customers;
	}
	
	@Override
	public int updateCustomer(Customer C) {//inserts rollback //passes in Object type to access its getters for the query performed
		try(Connection conn = DriverManager.getConnection(url,username,password)){

			PreparedStatement ps = conn.prepareStatement("UPDATE bank_Customers SET account_Tracker=? WHERE Username=?");
			ps.setInt(1, C.getAccount_tracker());
			ps.setString(2, C.getUsername());
			ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int deleteCustomer(Customer C) {//inserts rollback //passes in Object type to access its getters for the query performed
		try(Connection conn = DriverManager.getConnection(url, username, password)){
	
			PreparedStatement ps = conn.prepareStatement("DELETE FROM bank_Customers WHERE Username=? ");
			ps.setString(1, C.getUsername());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
