package Q13;

public class triangle {

	public static void main(String[] args) {
				boolean check = true;							//boolean value used to check
				
				for (int i = 1; i <= 4; i++) {					//nested for loop used to create tree
		            for (int j = 1; j <= i; j++) {
		                if (check) 								//if check is true, then print check and if not print 1
		                    System.out.print("0 ");
		                else 
		                    System.out.print("1 ");

		                check = !check;							//since 1 and 0 are alternating reverse check to print tree
		            }
		            System.out.println();						//skip to next line
				}
			}
	}

