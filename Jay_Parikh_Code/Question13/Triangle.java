package Question13;

public class Triangle {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
		}

	}
}