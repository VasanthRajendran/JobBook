package services;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dao.LoginDB;
import dao.UserDB;
import dataObjects.Login;
import dataObjects.User;


@Path("/UserService")
public class UserService {
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUser()
	{
		UserDB u = new UserDB();
		//user = u.showUser();
		User userjson = new User();	
		//userjson = u.showUser();
		Gson gson = new Gson();
		System.out.println("UserService.getUser()");
		return gson.toJson(userjson);
	}
	
	
	@GET
	@Path("/user/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserInfo(@PathParam("name") String name)
	{
		UserDB u = new UserDB();
		User userjson = new User();	
		//userjson = u.showUserInfo(name);
		Gson gson = new Gson();
		System.out.println("UserService.getUser()");
		return gson.toJson(userjson);
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public String loginUser(String loginjson)
	{
		System.out.println("reaching login");
		Gson gson = new Gson();
		Login login = gson.fromJson(loginjson, Login.class);
		LoginDB logindb = new LoginDB();
		String status =  logindb.validateUser(login);	
		if(status.equalsIgnoreCase("success"))
		{
			return "success";
		}
		else 
		{
			return "failure";
		}
	}
	
	@POST
	@Path("/adduser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void Adduser(String userjson)
	{
		System.out.println("Reaching userservice");
		Gson gson = new Gson();
		User user = gson.fromJson(userjson, User.class);
		UserDB udb = new UserDB();
	    udb.Adduser(user);
	}
}
