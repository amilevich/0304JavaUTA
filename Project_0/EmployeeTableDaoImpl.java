package bankingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bankingapp.EmployeeTable;

public class EmployeeTableDaoImpl implements EmployeeTableDao {

	/*
	 * JDBC API
	 * 
	 * Important Interfaces: Connection - allows us to connect to our db Statement -
	 * allows for SQL injection PreparedStatement - precompiles the SQL string
	 * without parameters once the parameters are added, they are only treated as
	 * values, never keywords CallableStatement - stored procedures
	 * 
	 * Statement vs PreparedStatement 1. PS has better readibility 2. PS more secure
	 * than statement (no SQL injections)
	 * 
	 * To connect to our database, we need 4 things: 1. URL 2. Username 3. Password
	 * 4. Driver (the jar that implements JDBC)
	 * 
	 * URL = endpoint + port + database name
	 */

	private static String url = "jdbc:oracle:thin:@mysqldatabase3.cwjd6odobf4o.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "angellocastro";
	private static String password = "Nightmarish1.";
	
	@Override
	public int insertEmployeeTable(EmployeeTable p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO EmployeeTable VALUES(?,?,?)");
			ps.setInt(1, p.getIndex());
			ps.setString(2, p.getName());
			ps.setString(3, p.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public EmployeeTable selectEmployeeTableByName(String name) {
		EmployeeTable employeetable = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EmployeeTable WHERE employeeUsername=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employeetable = new EmployeeTable(rs.getInt("employeeIndex"), rs.getString("employeeUsername"), rs.getString("employeePassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return employeetable;
	}

	@Override
	public int updateEmployeeTable(EmployeeTable p) { //might need to modify this method
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE EmployeeTable SET employeePassword=? WHERE employeeUsername=?");
			ps.setInt(1, p.getIndex());
			ps.setString(2, p.getName());
			ps.setString(3, p.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployeeTable(EmployeeTable p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM EmployeeTable WHERE employeeUsername=?");
			ps.setString(1, p.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// FOR AUTOINCREMENT
	@Override
	public int nextSequence() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT acc_seq.NEXTVAL FROM dual");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}
	// @Override
	// public int insertAccount(Account a) {
	// int id = 0;
	// try(Connection conn = DriverManager.getConnection(url, username, password)) {
	// PreparedStatement ps = conn.prepareStatement("INSERT INTO account VALUES(?,
	// ?)");
	// id = nextSequence();
	// ps.setInt(1, id);
	// ps.setDouble(2, a.amount);
	// ps.executeUpdate();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return id+1;
	// }

	@Override
	public List<EmployeeTable> selectAllEmployeeTables() {
		List<EmployeeTable> employeetables = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EmployeeTable");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				employeetables.add(new EmployeeTable(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeetables;
	}

}
