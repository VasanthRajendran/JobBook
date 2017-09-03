package services;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dao.JobsDB;
import dataObjects.Jobs;

@Path("/JobsService")
public class JobsService {
	
	@POST
	@Path("/addJob")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addJobDesc(String jobsJson)
	{
		System.out.println("Reaches jobs service");
		Gson gson = new Gson();
		Jobs jobs = gson.fromJson(jobsJson, Jobs.class);
		JobsDB jobsDb = new JobsDB();
		System.out.println(jobs.getJobType());
		System.out.println(jobs.getLocation());
		System.out.println(jobs.getPhoneNo());
		System.out.println(jobs.getTitle());
		System.out.println(jobs.getDescription());
		System.out.println(jobs.getSalary());
		jobsDb.addJobDesc(jobs);
	}
	
	@GET
	@Path("/getJob/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getJobDesc(@PathParam("name") String name)
	{
		System.out.println("Reaching getJobs");
		JobsDB jobsDb = new JobsDB();
		Jobs jobs = jobsDb.getJobDesc(name);
		Gson gson = new Gson();
		return gson.toJson(jobs);
	}

}
