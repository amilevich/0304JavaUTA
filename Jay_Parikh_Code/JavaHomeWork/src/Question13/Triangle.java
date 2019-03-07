package Question13;

public class Triangle {

	public static void main(String[] args) {
		//boolean checker
		boolean zero = true;
		
		//nested loop that creates the tree in the shape we want
		for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
            	
            	//if zero is true, then print zero and if not print 1
                if (zero) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                    
                }
                //because the 0's and 1's are alternating we just switch which one we want to print
                zero = !zero;
            }
            //print
            System.out.println();
		}

	}
}