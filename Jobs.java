package dataObjects;

public class Jobs {
private String title;
private String location;
private int phoneNo;
private String jobType;
private String description;
private int salary;

public Jobs()
{
	
}
public Jobs(String title,String location, int phoneNo, String jobType,String description,int salary)
{
	this.title = title;
	this.location = location;
	this.phoneNo = phoneNo;
	this.jobType = jobType;
	this.description = description;
	this.salary = salary;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public int getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(int phoneNo) {
	this.phoneNo = phoneNo;
}
public String getJobType() {
	return jobType;
}
public void setJobType(String jobType) {
	this.jobType = jobType;
}


}
