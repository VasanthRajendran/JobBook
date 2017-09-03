package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dataObjects.Jobs;

public class JobsDB {
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public void addJobDesc(Jobs jobs) {
		try {
			DBconnection DB = new DBconnection();
			connect = DB.dbConnect();
			preparedStatement = connect.prepareStatement("insert into jobs values (?,?,?,?,?,?)");
			preparedStatement.setString(1, jobs.getTitle());
			preparedStatement.setString(2, jobs.getLocation());
			preparedStatement.setInt(3, jobs.getPhoneNo());
			preparedStatement.setString(4, jobs.getJobType());
			preparedStatement.setString(5,jobs.getDescription());
			preparedStatement.setInt(6, jobs.getSalary());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Jobs getJobDesc(String name)
	{
		try
		{
		DBconnection DB = new DBconnection();
		connect=DB.dbConnect();
		preparedStatement = connect.prepareStatement("Select * from jobs where title = (?)");
		preparedStatement.setString(1, name);
		resultSet = preparedStatement.executeQuery();
		String title = null;
		String location = null;
		int phoneNo = 0;
		String jobType = null;
		String description = null;
		int salary = 0;
		while(resultSet.next())
		{
			title = resultSet.getString("title");
			location = resultSet.getString("location");
			phoneNo = resultSet.getInt("phoneNo");
			jobType = resultSet.getString("jobType");
			description = resultSet.getString("description");
			salary = resultSet.getInt("salary");
			Jobs jobs = new Jobs(title, location,phoneNo,jobType,description,salary);
			return jobs;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
