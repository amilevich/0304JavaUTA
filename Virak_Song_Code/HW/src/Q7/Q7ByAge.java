package Q7;

import java.util.Comparator;

public class Q7ByAge implements Comparator<Q7Emp>{ // implements class Q7Emp to compare
	@Override
	public int compare(Q7Emp o1, Q7Emp o2) {
		if (o1.getAge()-o2.getAge()> 0) {
			return 1;
		} else if (o1.getAge()-o2.getAge() < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}
