import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Customer implements Serializable{

	
	/**
	 * 
	 */
	private static final String filename = "./bankAccount.txt";
	private static final long serialVersionUID = 1L;
	private static int counter;
	private String fName;
	private String lName;
	private String userName;
	private String password;
	
	
	//made me make it protected 
	protected static HashMap<String, Customer> loginStuff = new HashMap<String, Customer>();
	
	
	public Customer(String fName, String lName, String userName, String password) {
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Customer [fName=" + fName + ", lName=" + lName + ", userName=" + userName + ", password=" + password
				+ "]";
	}
	
	public static Customer logIn(String userName, String password) {
		if(loginStuff.containsKey(userName)) 
			if(loginStuff.get(userName).getPassword().equals(password)) {
				return loginStuff.get(userName);
			}
		return null;
	}

	public static boolean userNameNotUnique(String un) {
		return loginStuff.containsKey(un);
	}

	public static boolean setUpAccount(BankAccount account) {
		if(Employee.reviewAccount(account) && !(loginStuff.containsKey(account.getUserName()))) {
			loginStuff.put(account.getUserName(), account);
		return true;
		}else {
			return false; 
			}
	}

	public static void readObject() {
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
	
			
				counter = (int) ois.readObject();
				ois.close();
				
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
		
		for(int i = 0; i < counter; i++) {
			
			try {
				
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
				
				
				BankAccount account = (BankAccount) ois.readObject();
				
				loginStuff.put(account.getUserName(), account);
				
				ois.close(); 
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
	}
	
	public static void writeObject() {
		
		Iterator<Entry<String, Customer>> iter = loginStuff.entrySet().iterator();
		
		counter = 0;
		
		while(iter.hasNext()) {
		
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
				counter++;
			oos.writeObject(iter.next().getValue());
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
		e.printStackTrace();}}
		
		try 
			(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
	
			
			oos.writeObject(counter);
			
			oos.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
		e.printStackTrace();}
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	


	
	
	
	
}
