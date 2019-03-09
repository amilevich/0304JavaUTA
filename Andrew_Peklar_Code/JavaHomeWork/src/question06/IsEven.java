package question06;

public class IsEven {

	public static void main(String[] args) {
		int odd = 21, even = 22;
		System.out.println(odd + " is even = " + isEven(odd));
		System.out.println(even + " is even = " + isEven(even));
	}
	
	public static boolean isEven(int num) {
		//if the binary ends in 0, it is even
		return (num & 1) == 0 ? true : false;
	}

}
