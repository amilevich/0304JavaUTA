package Q15;

public class Implement implements Basic{
	//methods that are implemented using basic operations
	@Override
	public void add(int x, int y) {
		System.out.println(x+y);
	}
	
	@Override
	public void sub(int x, int y) {
		System.out.println(x-y);
	}
	
	@Override
	public void multi(int x, int y) {
		System.out.println(x*y);
	}
	
	@Override
	public void div(int x, int y) {
		System.out.println(x/y);
	}

}
