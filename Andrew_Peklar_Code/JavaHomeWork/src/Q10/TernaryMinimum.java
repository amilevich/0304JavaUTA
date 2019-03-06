package Q10;

public class TernaryMinimum {

	public static void main(String[] args) {
		System.out.println(tMin(2,4));
	}
	
	private static int tMin(int a, int b) {
		return (a > b) ? a : b;
	}
}
