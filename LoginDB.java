package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dataObjects.Login;

public class LoginDB {
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public String validateUser(Login login)
	{
		try
		{
			DBconnection db = new DBconnection();
			connect = db.dbConnect();
			preparedStatement = connect.prepareStatement("select * from loginEmployer where emailID = ?");
			preparedStatement.setString(1, login.getemailID());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				if(resultSet.getString("emailID").equalsIgnoreCase(login.getemailID()) && resultSet.getString("password").equalsIgnoreCase(login.getPassword()))
				{
					return "Success";
				}
				else
				{
					return "failure";
				}
			}
			return "failure";	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "failure";
	}

}
