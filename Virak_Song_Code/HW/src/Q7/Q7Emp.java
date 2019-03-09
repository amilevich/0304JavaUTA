package Q7;

class Q7Emp implements Comparable<Q7Emp>{
	
	
	String name;
	String department;
	int age;
	
	public Q7Emp(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Q7Emp [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public Q7Emp(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	@Override
	public int compareTo(Q7Emp o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
}
