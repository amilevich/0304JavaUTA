package appDriver;

public class WithdrawTooLargeException extends Exception {
	
	public WithdrawTooLargeException() {
		
	}
	public WithdrawTooLargeException(String message) {
		super(message);
	}
}
