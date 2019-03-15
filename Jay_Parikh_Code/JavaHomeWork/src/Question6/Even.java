package Question6;

public class Even {

	public static void main(String[] args) {
		int x = 5;
		
		int z = x/2; //divide x by 2
		int w = z * 2; //multiple z by 2
		
		if (x == w) {   // compare w and x and if true then its even because integers do not have decimal points so they just cutoff decimal
			System.out.println("EVEN :)");
		}else {
			System.out.println("ODD :(");
		}
	}

}
