package bankingapp;

import java.util.List;

import bankingapp.MoneyTable;

public interface MoneyTableDao {
	
	// CREATE
	public int insertMoneyTable(MoneyTable p);
	
	// READ
	public MoneyTable selectMoneyTableByName(String name);
	public List<MoneyTable> selectAllMoneyTables();
	
	// UPDATE
	public int updateMoneyTable(MoneyTable p);
	
	// DELETE
	public int deleteMoneyTable(MoneyTable p);

	int nextSequence();
}