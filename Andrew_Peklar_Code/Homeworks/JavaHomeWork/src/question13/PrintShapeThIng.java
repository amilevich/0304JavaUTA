package question13;

public class PrintShapeThIng {
	public static void main(String[] args) {
		int i = 0;
		String tower = "";
		while(++i != 5) {
			tower = (((i&1) ==0) ? "1" : "0") + tower;
			System.out.println(tower);
		}
	}
}
