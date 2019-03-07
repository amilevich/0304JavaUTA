package Question19;

import java.util.ArrayList;

public class Numbers {

	public static ArrayList<Integer> aList = new ArrayList<>();
	
	public static void main(String[] args) {

		int even = 0, odd = 0;
		for (int i = 1; i < 11; i++) {
			aList.add(i);
		}
		System.out.println("First List: " + aList);

		for (int j = 0; j <= aList.size(); j++) {
			if (j % 2 == 0) {
				even += j;
			} else {
				odd += j;
			}
		}

		for (int k = 0; k <= aList.size() - 1; k++) {
			isPrime(k);
		}
		
		System.out.println("Even total: " + even);
		System.out.println("Odd total: " + odd);
		System.out.println("Second List: " + aList);

	}
	
	public static void isPrime(int f) {
		boolean bo = false;	//Boolean checker
		if(f == 1) { 	//1 is not prime
			bo = false;
		}
		for(int i = 2; i < f; i++) { //loop so we can check all possible factors to make sure a value is prime
			if(f % i == 0) {      //if the modulo is 0 then the value is not prime
				bo = true;		  //so we set the boolean to false
			}
		}
		if(!bo) { 		 //if it is prime based on our check
			 //print
			System.out.println(f);
			//aList.remove(f);
		}

	}

}
