import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankTest {
	
	public BankTest() {

			
		}
		
		BankAccount lane = new BankAccount("Lane", "Anderson", "LaneAnd", "flower10", 50, "Lane");
	
		@Test
		public void successfulDeposit() {
			
			assertEquals("true", true, lane.deposit(10));
		}
		
		@Test
		public void unsuccessfulDeposit() {
		
			assertEquals("false", false, lane.deposit(-10));
		}
		
		@Test
		public void successfulWithdraw() {
		
			assertEquals("true", true, lane.withdraw(10));
		}
		
		@Test
		public void unsuccessfulWithdraw() {
			
			assertEquals("false", false, lane.withdraw(-10));
		}	
		
		@Test
		public void overWithdraw() {
			
			assertEquals("false", false, lane.withdraw(60));
		}
		
		@Test
		public void successfulTransfer() {
			
			BankAccount gen = new BankAccount("Genevieve", "Wood", "GenWood", "pink5", 100, "gen");
			
			BankAccount.setUpAccount(gen);
			
			assertEquals("true", true, lane.transferTo(gen.getUserName(), 25));
		}

		@Test
		public void unsuccessfulTransfer() {
		
			BankAccount gen = new BankAccount("Genevieve", "Wood", "GenWood", "pink5", 100, "gen");
			
			BankAccount.setUpAccount(gen);
			
			assertEquals("false", false, lane.transferTo(gen.getUserName(), -10));
		}
		
		@Test
		public void overdrawTransfer() {
			
			BankAccount gen = new BankAccount("Genevieve", "Wood", "GenWood", "pink5", 100, "gen");
			
			BankAccount.setUpAccount(gen);
			
			assertEquals("false", false, lane.transferTo(gen.getUserName(), 75));
		}
		
	
}
