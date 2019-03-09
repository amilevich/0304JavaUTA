package question12;
import java.util.Arrays;
import java.util.Random;
public class ForEach {
	private static int[] arr = new int [100];
	
	public static void main(String[] args) {
		int index = -1;
		Random rand = new Random();
		while(++index != 100) arr[index] = rand.nextInt(101);
		printEvens();
	}
	
	static void printEvens() {
		Arrays.stream(arr)
			  .filter(i -> i%2 == 0)
			  .forEach(System.out::println);
	}

}
