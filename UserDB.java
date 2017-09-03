package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataObjects.Login;
import dataObjects.User;

public class UserDB {
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
//
//	public User showUser() {
//		try {
//			DBconnection db = new DBconnection();
//			connect = db.dbConnect();
//			preparedStatement = connect.prepareStatement("Select * from userinfo");
//			resultSet = preparedStatement.executeQuery();
//			int id;
//			String name;
//			String profession;
//			String password= null;
//		//	List<User> user = new ArrayList<User>();
//			while(resultSet.next())
//			{
//				id = resultSet.getInt("ID");
//				name = resultSet.getString("FirstName");
//				profession = resultSet.getString("Profession");
//				return new User(id,name,password,profession);
//				//user.add(new User(id,name,profession));
//			}
//			return null;
//			//return user;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	public void Adduser(User user) {
		try {
			DBconnection db = new DBconnection();
			connect = db.dbConnect();
			preparedStatement = connect.prepareStatement("insert into  EmployerInfo values (?,?,?,?,?)");
			preparedStatement.setString(1, user.getCompanyName());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setInt(3, user.getEmployeeNo());
			preparedStatement.setString(4, user.getEmailId());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.execute();
			preparedStatement = connect.prepareStatement("insert into loginEmployer values (?,?)");
			preparedStatement.setString(1, user.getEmailId());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public User showUserInfo(String name) {
//		try {
//			DBconnection db = new DBconnection();
//			connect = db.dbConnect();
//			preparedStatement = connect.prepareStatement("Select * from userinfo where FirstName like (?) ");
//			preparedStatement.setString(1, name);
//			resultSet = preparedStatement.executeQuery();
//			int id;
//			String uname;
//			String profession;
//			String password = null;
//			while(resultSet.next())
//			{
//				id = resultSet.getInt("ID");
//				uname = resultSet.getString("FirstName");
//				profession = resultSet.getString("Profession");
//				return new User(id,uname,password,profession);
//			}
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
	
}

