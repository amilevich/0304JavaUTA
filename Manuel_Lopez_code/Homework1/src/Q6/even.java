package Q6;

public class even {

	public static void main(String[] args) {
		even(45);										//method call to check if integer is even
	}
	
	static void even(int x) {
		if((x&1)==0) {									//use the bitwise operator to check if integer is even by looking at lowest order bit(first number in binary)
			System.out.println("Number is even");		//if lowest order bit is 0 then number is even
		}
		else
			System.out.println("Number is odd"); 		//if lowest order bit is not 0 then number is odd
	}

}
