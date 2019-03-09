//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console. Note: understand now. Prime number is the number beside itself and 1


import java.util.ArrayList;

public class Q9 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i=2; i<=100; i++) { // loop from 1 to 100 and add to ArrayList
			num.add(i);	
			
			Boolean T = true;
			
				for (int j=2; j<i; j++) { //loop till j<i 
					
						if (i%j == 0) {	 // if remainder is zero, the number can be devided by other, it is not a prime
							T = false;   // and set to be false for not a prime number
						}
					
				}
				
				if (T==true) { // if prime number, print it.
					System.out.print(i + " ");	
			
			}
			
		}
		  	
		}
	}





