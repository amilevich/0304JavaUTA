package Q6;
import java.util.Scanner;
public class Modul {

static Scanner scan = new Scanner(System.in);

public static void main(String[] args) 
{
	boolean ans = false;
		System.out.print("Type any Integer: ");
		int num = scan.nextInt();
		if(num >=1) {ans = Check(num);}
		if(ans == true){System.out.println("Number is Even");}
		else if(ans == false) {System.out.println("Number is Odd");}
		else {System.out.println("Try Again");}
}


static boolean Check (int number) 
{
	return ((number/2)*2 == number); 
}


}

