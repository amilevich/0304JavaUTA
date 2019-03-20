package appDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import appModels.Employee;

//TURN AUTO COMMIT OPTION OFF
public class EmployeeDaoImple implements EmployeeDao {

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cmseb0jui8wp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "AlimWooden"; //Username
	private static String password = "Donkey123"; //Password
	
	//Logger Log = Logger.getGlobal();
	
	@Override
	public int insertEmployee(Employee E) {//commits //passes in Object type to access its getters for the query performed
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO bank_Employees VALUES(?,?,?)");//NUMBER OF QUESTION MARKS CORRESPOND TO TABLE COLUMNS
			ps.setString(1, E.getUsername());
			ps.setInt(2, E.getPassword());
			ps.setInt(3, E.getAdmin_privileges());
			ps.executeQuery();
			//Log.info("Employee added");
		}
		catch(SQLException e){e.printStackTrace();}

		return 0;
	}
	
	@Override
	public Employee getEmployeeByUsername(String UserName) {
		Employee E = null;
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_Employees WHERE Username=?");//NUMBER OF QUESTION MARKS CORRESPOND TO TABLE COLUMNS
			ps.setString(1, UserName);
			ResultSet rs = ps.executeQuery();
			//Log.info("Query was executed");
			while(rs.next()) {
				E = new Employee(rs.getString("Username"),rs.getInt("Password"),rs.getInt("Admin_Access"));
			}
		}
		catch(SQLException e){e.printStackTrace();}//Log.info("Couldn't get employee");
		
		return E;//for debugging purposes
	}
	
	
	@Override
	public ArrayList<Employee> EmployeeArchive() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_Employees");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employees.add(new Employee(rs.getString("Username"),rs.getInt("Password"),rs.getInt("Admin_Access")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return employees;
	}
	@Override
	public int updateEmployee(Employee E) {//insert rollback //passes in Object type to access its getters for the query performed
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE bank_Employees SET Admin_Access=? WHERE Username=?");
			ps.setString(1, E.getUsername());
			ps.setInt(2, E.getPassword());
			ps.setInt(3, E.getAdmin_privileges());
			ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int deleteEmployee(Employee E) {//insert rollback //passes in Object type to access its getters for the query performed
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM bank_Employees WHERE Username=? ");
			ps.setString(1, E.getUsername());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
