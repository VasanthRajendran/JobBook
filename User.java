package dataObjects;

public class User {
	
	private String companyName;
	private String firstName;
	private int employeeNo;
	private String emailId;
	private String password;
	
	public User()
	{
		
	}
	
	public User(String companyName, String firstName,int employeeNo,String emailId,String password)
	{
		this.companyName = companyName;
		this.firstName = firstName;
		this.employeeNo = employeeNo;
		this.emailId = emailId;
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}
}