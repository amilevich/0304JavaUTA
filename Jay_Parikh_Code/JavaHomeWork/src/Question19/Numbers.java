package Question19;

import java.util.ArrayList;

public class Numbers {

	public static ArrayList<Integer> aList = new ArrayList<>();
	
	public static void main(String[] args) {

		int even = 0, odd = 0;
		//add numbers from 1 -> 10
		for (int i = 1; i < 11; i++) {
			aList.add(i);
		}
		//print
		System.out.println("First List: " + aList);

		//loop through array list
		for (int j = 0; j <= aList.size(); j++) {
			if (j % 2 == 0) {	//even checker
				even += j;		//if even then add to even total
			} else {
				odd += j;		//if odd then add to odd total
			}
		}

		
		//loop through arraylist and remove any primes
		for (int k = 0; k < aList.size(); k++) {
			if(isPrime(aList.get(k))) {  	//prime checker
				aList.remove(k);			//remove the primes
			}
		}
		
		aList.remove(aList.indexOf(2)); //special case of 2
		//prints
		System.out.println("Even total: " + even);
		System.out.println("Odd total: " + odd);
		System.out.println("Second List: " + aList);
}
	
	public static boolean isPrime(int f) {
		for(int i = 2; i < f; i++) { //loop so we can check all possible factors to make sure a value is prime
			
			if(f % i == 0) {      //if the modulo is 0 then the value is not prime
				return false;		  //so we set the boolean to false
			}
		}
		return true; 		 //if it is prime based on our check		
		}

	

}
