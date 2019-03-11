package accountObjects;

import java.util.Arrays;

public class JointAccount extends AccountParent {
	
	//Account object

	//user first names
	public String [] firstN = new String [2];
	
	
	//user last names
	public String [] lastN = new String [2];

	//Social Security numbers
	public Integer[] ssecurity = new Integer [2];
	
	//Joint User Names
	public String [] UserN = new String[2];
	
	
	
	public String[] getFirstN() {
		return firstN;
	}

	public void setFirstN(String[] firstN) {
		this.firstN = firstN;
	}

	public String[] getLastN() {
		return lastN;
	}

	public void setLastN(String[] lastN) {
		this.lastN = lastN;
	}
	
	public String[] getUserN() {
		return UserN;
	}

	public void setUserN(String[] userN) {
		UserN = userN;
	}

	public Integer[] getSsecurity() {
		return ssecurity;
	}

	public void setSsecurity(Integer [] ssecurity) {
		this.ssecurity = ssecurity;
	}
	
	

	public JointAccount(String[] firstN, String[] lastN, Integer [] ssecurity, String [] UserN, String accountName) {
		super(accountName);
		this.firstN = firstN;
		this.lastN = lastN;
		this.ssecurity = ssecurity;
		this.UserN = UserN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(UserN);
		result = prime * result + Arrays.hashCode(firstN);
		result = prime * result + Arrays.hashCode(lastN);
		result = prime * result + Arrays.hashCode(ssecurity);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JointAccount other = (JointAccount) obj;
		if (!Arrays.equals(UserN, other.UserN))
			return false;
		if (!Arrays.equals(firstN, other.firstN))
			return false;
		if (!Arrays.equals(lastN, other.lastN))
			return false;
		if (!Arrays.equals(ssecurity, other.ssecurity))
			return false;
		return true;
	}

	
	
	
	
}
