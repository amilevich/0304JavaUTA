package appDao;

import java.util.List;

import appModels.Customer;

public interface CustomerDao {

		//CREATE - INSERT
		public int insertCustomer(Customer C);
		
		//READ - SELECT
		public Customer getCustomerByUsername(String username1);
		public List<Customer> CustomerArchive();
		
		//UPDATE
		public int updateCustomer(Customer C);
		
		//DELETE
		public int deleteCustomer(Customer C);
		
}
