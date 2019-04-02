package question3;

public class ReverseString {
	
	public static void main(String[] args) {
		String forwardString = "The night is dark and full of terrors";
		for(int i = 0; i<forwardString.length(); i++) {
			forwardString = forwardString.substring(1, forwardString.length() - i) + forwardString.substring(0,1) + forwardString.substring(forwardString.length()-i, forwardString.length());
		}
		System.out.println(forwardString);
	}
}
 
/*
String forwardString = "Winter";
char[] splitForwardString = forwardString.toCharArray();

String backwardString = String.valueOf(splitForwardString);

System.out.println(backwardString);

for(int i = backwardString.length; i<backwardString.length - 1; i--) {
for(int j = 0; j < backwardString.length - 1; j++) {
	backwardString[j] = backwardString[i];
}
}
backwardString[0] = backwardString[backwardString.length - 1];
backwardString[1] = backwardString[backwardString.length - 2];
backwardString[2] = backwardString[backwardString.length - 3];
backwardString[3] = backwardString[backwardString.length - 4];
backwardString[4] = backwardString[backwardString.length - 5];
backwardString[5] = backwardString[backwardString.length - 6];

System.out.print(backwardString[0]);
System.out.print(backwardString[1]);
System.out.print(backwardString[2]);
System.out.print(backwardString[3]);
System.out.print(backwardString[4]);
System.out.print(backwardString[5]);

int stringLength = backwardString.length;
int j = 1;
for(int i = 0; i<=stringLength - 1; i++) {
	backwardString[i] = backwardString[backwardString.length - j++];
	j++;
}
	//backwardString[i] = backwardString[backwardString.length-i-1];
for(int i = 0; i<stringLength - 1; i++) {
	System.out.print(backwardString[i]);
}
*/