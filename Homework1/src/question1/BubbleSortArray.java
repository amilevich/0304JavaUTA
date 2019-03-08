package question1;

public class BubbleSortArray {
	
	public static void main(String[] args) {
		
		//int[] randomArray;
		//randomArray = new int[11];
		
		int[] randomArray = new int[11];
		
		randomArray[0] = 1;
		randomArray[1] = 0;
		randomArray[2] = 5;
		randomArray[3] = 6;
		randomArray[4] = 3;
		randomArray[5] = 2;
		randomArray[6] = 3;
		randomArray[7] = 7;
		randomArray[8] = 9;
		randomArray[9] = 8;
		randomArray[10] = 4;
		
		System.out.print("Original array: ");
		System.out.print(randomArray[0] + " ");
		System.out.print(randomArray[1] + " ");
		System.out.print(randomArray[2] + " ");
		System.out.print(randomArray[3] + " ");
		System.out.print(randomArray[4] + " ");
		System.out.print(randomArray[5] + " ");
		System.out.print(randomArray[6] + " ");
		System.out.print(randomArray[7] + " ");
		System.out.print(randomArray[8] + " ");
		System.out.print(randomArray[9] + " ");
		System.out.println(randomArray[10]);
		
		int[] tempVar = new int[11];
		tempVar[0] = 0;
		tempVar[1] = 0;
		tempVar[2] = 0;
		tempVar[3] = 0;
		tempVar[4] = 0;
		tempVar[5] = 0;
		tempVar[6] = 0;
		tempVar[7] = 0;
		tempVar[8] = 0;
		tempVar[9] = 0;
		tempVar[10] = 0;
		
		for(int j = 0; j<randomArray.length-1; j++) {
			for(int i = 0; i<randomArray.length-j-1; i++) {
				if(randomArray[i+1] > randomArray[i]) {
					tempVar[i] = randomArray[i];
					randomArray[i] = randomArray[i+1];
					randomArray[i+1] = tempVar[i];
				}
			}
		}
		
		System.out.print("Bubble sorted array: ");
		System.out.print(randomArray[0] + " ");
		System.out.print(randomArray[1] + " ");
		System.out.print(randomArray[2] + " ");
		System.out.print(randomArray[3] + " ");
		System.out.print(randomArray[4] + " ");
		System.out.print(randomArray[5] + " ");
		System.out.print(randomArray[6] + " ");
		System.out.print(randomArray[7] + " ");
		System.out.print(randomArray[8] + " ");
		System.out.print(randomArray[9] + " ");
		System.out.print(randomArray[10]);
	}
}