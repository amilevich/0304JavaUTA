package Q7;

import java.util.Comparator;

public class Q7ByDep implements Comparator<Q7Emp> {
	@Override
	public int compare(Q7Emp o1, Q7Emp o2) {
		if (o1.getDepartment().compareTo(o2.getDepartment()) > 0) {
			return 1;
		} else if (o1.getDepartment().compareTo(o2.getDepartment()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}


}
