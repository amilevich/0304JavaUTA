package bankingapp;

import java.util.List;

import bankingapp.CustomerTable;

public interface CustomerTableDao {
	
	// CREATE
	public int insertCustomerTable(CustomerTable p);
	
	// READ
	public CustomerTable selectCustomerTableByName(String name);
	public List<CustomerTable> selectAllCustomerTables();
	
	// UPDATE
	public int updateCustomerTable(CustomerTable p);
	
	// DELETE
	public int deleteCustomerTable(CustomerTable p);

	int nextSequence();
}