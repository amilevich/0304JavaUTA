package question14;
import java.time.LocalDateTime;
import java.util.Arrays;

public class SwitchCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		int case_num = 3;
		
		double playNum = 27;
		String str = "I am learning Core Java";
		
		switch(case_num) {
			case 1:
				System.out.println("Square root of " + playNum + " = " + Math.sqrt(playNum));
				break;
			case 2: 
				System.out.println("Today's date: " + currentTime.toLocalDate());
				break;
			case 3:
				 String[] stringArray = str.split(" ");
				 System.out.println(Arrays.toString(stringArray));
				 break;
		}

	}

}
