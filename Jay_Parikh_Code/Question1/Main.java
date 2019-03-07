package Question1;

public class Main {
	//These are just here for question 11
	public static float x = 18.0f;
	public static float y = 22.0f;
	
	public static void main(String[] args) {
		
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4}; 				//array to sort
		
		for(int j = 0; j < arr.length; j++) {			//check if complete array is sorted multiple times
			for(int i = 0; i < arr.length - 1; i++) {	    //compare each neighbor once
				if (arr[i] > arr [i + 1]) {					//if left is > than right
					int temp = arr[i];						//then switch them
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		for(int k = 0; k < arr.length; k++) {
			System.out.println(arr[k]);						//print them out
		}
	}

}
