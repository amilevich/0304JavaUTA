package Question12;

public class EvenNumbers {

	public static void main(String[] args) {
		
		int[] numArray = new int[101];  //array of size 101
		for(int i = 0; i < numArray.length; i++) {
			numArray[i] = i;	//store numbers 1 - 100
		}
		
		for(int n : numArray) { //enhanced for loop
			if(n % 2 == 0) {	//if a number is divisible by 2 without a remainder then its even
				System.out.println(n);  //print said even number
			}
		}
		
	}

}
