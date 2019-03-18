package bankingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bankingapp.MoneyTable;

public class MoneyTableDaoImpl implements MoneyTableDao {

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
	public int insertMoneyTable(MoneyTable p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO MoneyTable VALUES(?,?,?)");
			ps.setInt(1, p.getIndex());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getMoney());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public MoneyTable selectMoneyTableByName(String name) {
		MoneyTable moneytable = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM MoneyTable WHERE customerUsername=?");
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				moneytable = new MoneyTable(rs.getInt("customerIndex"), rs.getString("customerUsername"), rs.getDouble("customerMoney"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return moneytable;
	}

	@Override
	public int updateMoneyTable(MoneyTable p) { //might need to modify this method
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE MoneyTable SET customerMoney=? WHERE customerUsername=?");
			ps.setDouble(1, p.getMoney());
			ps.setString(2, p.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMoneyTable(MoneyTable p) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM MoneyTable WHERE customerUsername=?");
			ps.setString(2, p.getName());
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
	public List<MoneyTable> selectAllMoneyTables() {
		List<MoneyTable> moneytables = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM MoneyTable");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				moneytables.add(new MoneyTable(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moneytables;
	}

}
