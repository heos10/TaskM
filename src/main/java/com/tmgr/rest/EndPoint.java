package com.tmgr.rest;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
@Path("/")
public class EndPoint 
{
	/*
	 * Authenticate USER 
	 * 
	 *  REQ: username and password
	 *  RES: success: false, true
	 * 
	 */
	
	@GET
	@Path("login")
	@Produces(MediaType.TEXT_PLAIN)
	public Response authenticate(@QueryParam("username") String username, @QueryParam("password") String password)
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		String output = init.authenticate(username, password);
		
		return Response.status(200).entity(output).build();
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	@GET
	@Path("register")
	@Produces(MediaType.TEXT_PLAIN)
	public Response register(@QueryParam("username") String username,
			@QueryParam("password") String password,
			@QueryParam("email") String email,
			@QueryParam("first_name") String first_name,
			@QueryParam("last_name") String last_name)
			
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		String output = init.register(username, password, email, first_name, last_name);
		
		return Response.status(200).entity(output).build();
	}
	
	
	/**
	 * 
	 * 
	 * @param username
	 * @return JSON user
	 */
	@GET
	@Path("getuser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@QueryParam("username") String username)
		
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		JSONObject rs = init.getuser(username);
		
		return Response.status(200).entity(rs.toString()).build();
	}
	
	
	@GET
	@Path("task/savetask")
	@Produces(MediaType.TEXT_PLAIN)
	public Response savetask(@QueryParam("username") String username,
			@QueryParam("title") String title,
			@QueryParam("message") String message,
			@QueryParam("date") String date,
			@QueryParam("priority") String priority)
			
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		String output = init.savetask(username, title, message, date, priority);
		
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("task/updatetask")
	@Produces(MediaType.TEXT_PLAIN)
	public Response updatetask(@QueryParam("id") String id,
			@QueryParam("username") String username,
			@QueryParam("title") String title,
			@QueryParam("message") String message,
			@QueryParam("date") String date,
			@QueryParam("priority") String priority,
			@QueryParam("iscompleted") String iscompleted)
	
			
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		String output = init.updatetask(id, username, title, message, date, priority, iscompleted);
		
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("task/gettask")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gettask(@QueryParam("username") String username)
			
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		JSONArray obj = init.gettask(username);
		JSONObject output = new JSONObject();
		output.put("array", obj);
		return Response.status(200).entity(output.toString()).build();
	}
	
	
	@GET
	@Path("task/deletetask")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deletetask(@QueryParam("username") String username,
			@QueryParam("id") String taskid)
			
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		String output = init.deletetask(username, taskid);
		
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("task/markcomplete")
	@Produces(MediaType.TEXT_PLAIN)
	public Response markcomplete(@QueryParam("username") String username,
			@QueryParam("id") String taskid)
			
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		String output = init.markcomplete(username, taskid);
		
		return Response.status(200).entity(output).build();
	}
	
	
	
	
	@GET
	@Path("task/getcompletedtask")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getcompletedtask(@QueryParam("username") String username)
			
	{
		InitDB init = new InitDB();
		
		System.out.println("in service" + username);
		JSONArray obj = init.getcompletedtask(username);
		JSONObject output = new JSONObject();
		output.put("array", obj);
		return Response.status(200).entity(output.toString()).build();
	}
	
	
	
	
	
	
	
	
	
	
	
}