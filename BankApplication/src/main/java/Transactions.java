
public interface Transactions {
	
	public boolean withdraw(double amt);
	
	public boolean deposit(double amt);
	
	public boolean transferTo(String to, double amt);

}
