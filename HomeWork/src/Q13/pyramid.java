package Q13;

import java.util.ArrayList;

public class pyramid {

	public static void main(String[] args) {
		boolean bool = false; //switch for printing 1 & 0
		ArrayList<Integer[]> AI = new ArrayList<Integer[]>(); //create a List of arrays
		int rows = 4;//number of rows
		
		
		for (int i = 1; i <= rows; i++) //FOR EACH LIST ENTRY ROW
		{int j =i; //nested loop index
		Integer[] IntA = new Integer[i]; //creates an integer array 
		AI.add(IntA); //adds array to list		
			while (j > 0) //counts down from index j
				{ IntA = AI.get(i-1);//pushes List position to created array
					if (bool == true)
					{//depending on bool position, either a 0 or 1
						// is pushed to the Integer[] in position j-1
						IntA[j-1] = 1;
					}
					else if (bool == false) 
					{
						IntA[j-1] = 0;
					}
					bool = !bool;// after if-else statement, bool switches
					j--; //j decrements
					System.out.print(IntA[j]);//prints Array entry
				}
			System.out.println(); //prints a new line
		}
	}

}
