package appDriver;

public class NoAccountDetectedException extends Exception {
	
	public NoAccountDetectedException() {
		
	}
	public NoAccountDetectedException(String message) {
		super(message);
	}
}
