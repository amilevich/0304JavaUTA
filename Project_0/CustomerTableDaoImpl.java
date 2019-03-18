package bankingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bankingapp.CustomerTable;

public class CustomerTableDaoImpl implements CustomerTableDao {

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
	public int insertCustomerTable(CustomerTable p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO CustomerTable VALUES(?,?,?)");
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
	public CustomerTable selectCustomerTableByName(String name) {
		CustomerTable customertable = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CustomerTable WHERE customerUsername=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				customertable = new CustomerTable(rs.getInt("customerIndex"), rs.getString("customerUsername"), rs.getString("customerPassword"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return customertable;
	}

	@Override
	public int updateCustomerTable(CustomerTable p) { //might need to modify this method
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE CustomerTable SET customerPassword=? WHERE customerUsername=?");
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
	public int deleteCustomerTable(CustomerTable p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM CustomerTable WHERE customerUsername=?");
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
	public List<CustomerTable> selectAllCustomerTables() {
		List<CustomerTable> customertables = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM CustomerTable");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				customertables.add(new CustomerTable(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customertables;
	}

}
