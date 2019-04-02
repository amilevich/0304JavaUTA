package bankingapp;

import java.util.List;

import bankingapp.EmployeeTable;

public interface EmployeeTableDao {
	
	// CREATE
	public int insertEmployeeTable(EmployeeTable p);
	
	// READ
	public EmployeeTable selectEmployeeTableByName(String name);
	public List<EmployeeTable> selectAllEmployeeTables();
	
	// UPDATE
	public int updateEmployeeTable(EmployeeTable p);
	
	// DELETE
	public int deleteEmployeeTable(EmployeeTable p);

	int nextSequence();
}