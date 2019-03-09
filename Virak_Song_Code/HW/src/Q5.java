
public class Q5 {
// hello is string
// substring (0, 2) // result "he"
	int n = 0;
	int m = 0;
	String s;
	
	public Q5(int n, int m){
		this.n = n;
		this.m = m;
	} 
	
	public Q5(String s) {
		this.s = s;
	}

	public void subStr(int i, int k) {
		while (i<=k) {
			System.out.print(s.charAt(i));
			i++;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Welcome";
		System.out.println(s);
		Q5 myQ5 = new Q5(s);
		myQ5.subStr(2, 5);
		
	}

}
