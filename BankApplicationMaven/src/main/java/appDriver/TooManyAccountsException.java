package appDriver;

public class TooManyAccountsException extends Exception {
	
	public TooManyAccountsException() {
		
	}
	
	public TooManyAccountsException (String message) {
		super(message);
	}

}
