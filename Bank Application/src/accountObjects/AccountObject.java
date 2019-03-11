package accountObjects;

public class AccountObject extends AccountParent {
	//Account object
	
	//user first name
		public String firstN;
		
		//user last name
		public String lastN;
		
		//Social Security
		int ssecurity;
		
		//Customer UserName
		String UserN;


		
	public String getFirstN() {
			return firstN;
		}


		public void setFirstN(String firstN) {
			this.firstN = firstN;
		}




		public String getLastN() {
			return lastN;
		}




		public void setLastN(String lastN) {
			this.lastN = lastN;
		}


		public String getUserN() {
			return UserN;
		}


		public void setUserN(String userN) {
			UserN = userN;
		}


		public int getSsecurity() {
			return ssecurity;
		}




		public void setSsecurity(int ssecurity) {
			this.ssecurity = ssecurity;
		}




	public AccountObject (String fName, String lName, int ssty, String UserN, String accountName) 
	{
		super(accountName);
		this.UserN = UserN;
		this.firstN = fName;
		this.lastN = lName;
		this.ssecurity = ssty;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((UserN == null) ? 0 : UserN.hashCode());
		result = prime * result + ((firstN == null) ? 0 : firstN.hashCode());
		result = prime * result + ((lastN == null) ? 0 : lastN.hashCode());
		result = prime * result + ssecurity;
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
		AccountObject other = (AccountObject) obj;
		if (UserN == null) {
			if (other.UserN != null)
				return false;
		} else if (!UserN.equals(other.UserN))
			return false;
		if (firstN == null) {
			if (other.firstN != null)
				return false;
		} else if (!firstN.equals(other.firstN))
			return false;
		if (lastN == null) {
			if (other.lastN != null)
				return false;
		} else if (!lastN.equals(other.lastN))
			return false;
		if (ssecurity != other.ssecurity)
			return false;
		return true;
	}



	
}
