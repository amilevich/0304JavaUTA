package Q12;

public class enhancedFor {
	
	static int[] list = new int[100];						//array for numbers
	static int[]evenList = new int[50];						//array for even numbers
	
	public static void main(String[] args) {
		
		createList();										//call method to create list of number 1 to 100
		createEvenList();									//call method to create list of even numbers
		System.out.print("Even numbers are: ");
		for(int x: evenList) {								//
			System.out.print(x+", ");						//<-print list of even numbers stored in evenList array using enhanced for loop
		}													//

	}
	
	static void createList() {								//
		for(int i=1; i <=100; i++)							//<- method to create list of numbers 1 to 100
			list[i-1]= i;									//
	}
	
	static void createEvenList() {							//method to store even numbers in evenList array
		int counter=0;
		for(int i: list)									//iterate through list of numbers 1-100 using enhanced for loop
		{
			if((i&1)==0) {									//use the bitwise operator to check if integer is even by looking at lowest order bit(first number in binary)
				evenList[counter]=i;						//if lowest order bit is 0 then number is even, store in evenList
				counter++;
			}
		}
	}

}
