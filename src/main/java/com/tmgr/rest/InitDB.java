package com.tmgr.rest;

import java.sql.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class InitDB {

	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/tmgr?zeroDateTimeBehavior=convertToNull";
	   static final String USER = "root";
	   static final String PASS = "root";

	   public String authenticate(String user, String password) {
		   String output ="";
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "SELECT * FROM user WHERE username='" + user + "' AND password='" + password + "'";
		      String sql = command;
		      ResultSet rs = stmt.executeQuery(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		      if(rs.next()){
		    	  
		    	  output = "true";
		      }
		      else{
		    	  output = "false";
		      }
		      
		       rs.close();

		      
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return output;
	   }
	   
	   public String register(String username, String password, String email, String first_name, String last_name) {
		   String output ="";
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "insert into USER(first_name, last_name, email, username, password, regdate) values ('" + first_name + "','" 
		    		    + last_name + "','" + email + "','" + username + "','" + password + "', CURDATE())";
		      String sql = command;
		      int rs = stmt.executeUpdate(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		      if(rs > 0){
		    	  
		    	  output = "true";
		      }
		      else{
		    	  output = "false";
		      }

		     conn.close();
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return output;
	   }
	   
	   
	   
	   public JSONObject getuser(String user) {
		   String output ="";
		   ResultSet rs = null;
		   JSONObject obj = new JSONObject();
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "SELECT * FROM user WHERE username='" + user + "'";
		      String sql = command;
		      rs = stmt.executeQuery(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		      if(rs.next()){
		    	  
		    	  obj.put("first_name", rs.getString("first_name"));
		    	  obj.put("last_name", rs.getString("last_name"));
		    	  obj.put("email", rs.getString("email"));
		    	  
		    	  output = "true";
		      }
		      else{
		    	  output = "false";
		      }

		      conn.close();
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return obj;
	   }
	   
	   
	   public String savetask(String username, String title, String message, String date, String priority) {
		   String output ="";
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "insert into tasks(username, title, message, date, priority) values ('" + username + "','" 
		    		    + title + "','" + message + "','" + date + "','" + priority + "')";
		      String sql = command;
		      int rs = stmt.executeUpdate(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		      if(rs > 0){
		    	  
		    	  output = "true";
		      }
		      else{
		    	  output = "false";
		      }

		      conn.close();
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return output;
	   }
	   
	   
	   public String updatetask(String id, String username, String title, String message, String date, String priority, String iscompleted) {
		   String output ="";
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "UPDATE tasks SET username = '" + username + "', title = '" 
		    		    + title + "', message = '" + message + "', date = '" + date + "', priority = '" + priority + "', iscompleted=" + iscompleted + " WHERE username='" + username + "' AND id=" + id;
		      String sql = command;
		      int rs = stmt.executeUpdate(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		      if(rs > 0){
		    	  
		    	  output = "true";
		      }
		      else{
		    	  output = "false";
		      }

		      conn.close();
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return output;
	   }
	   
	   
	   
	   public JSONArray gettask(String user) {
		   String output ="";
		   ResultSet rs = null;

		   JSONArray jsonArray = new JSONArray();
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "SELECT * FROM tasks WHERE username='" + user + "' AND iscompleted=0";
		      String sql = command;
		      rs = stmt.executeQuery(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		    	  
		    	  
		          while (rs.next()) {
		              int total_rows = rs.getMetaData().getColumnCount();
		              System.out.println("Total rows: " + total_rows);
		              JSONObject obj1 = new JSONObject();
		              for (int i = 0; i < total_rows; i++) {
		                  obj1.put(rs.getMetaData().getColumnLabel(i+1)
		                          .toLowerCase(), rs.getObject(i+1));
		                 
		              }
		              jsonArray.put(obj1);
		          }
		    	  
		    	  
		    	  output = "true";
		      
		    

		      conn.close();
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return jsonArray;
	   }
	   
	   
	   
	   public String deletetask(String username, String taskid) {
		   String output ="";
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "DELETE FROM tasks WHERE username = '" + username + "' AND id =" + taskid;
		      String sql = command;
		      int rs = stmt.executeUpdate(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		      if(rs > 0){
		    	  
		    	  output = "true";
		      }
		      else{
		    	  output = "false";
		      }

		      conn.close();
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return output;
	   }
	   
	   
	   
	   public String markcomplete(String username, String id) {
		   String output ="";
		   String iscompleted = "1";
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "UPDATE tasks SET iscompleted=" + iscompleted + " WHERE id=" + id;
		      System.out.println("Command" + command);
		      String sql = command;
		      int rs = stmt.executeUpdate(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		      if(rs > 0){
		    	  
		    	  output = "true";
		      }
		      else{
		    	  output = "false";
		      }

		      conn.close();
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return output;
	   }
	   
	   
	   

	   public JSONArray getcompletedtask(String user) {
		   String output ="";
		   ResultSet rs = null;

		   JSONArray jsonArray = new JSONArray();
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String command = "SELECT * FROM tasks WHERE username='" + user + "' AND iscompleted=" + 1;
		      String sql = command;
		      rs = stmt.executeQuery(sql);
		      System.out.println("Command" + command);
		      System.out.println(rs);
		    	  
		    	  
		          while (rs.next()) {
		              int total_rows = rs.getMetaData().getColumnCount();
		              System.out.println("Total rows: " + total_rows);
		              JSONObject obj1 = new JSONObject();
		              for (int i = 0; i < total_rows; i++) {
		                  obj1.put(rs.getMetaData().getColumnLabel(i+1)
		                          .toLowerCase(), rs.getObject(i+1));
		                 
		              }
		              jsonArray.put(obj1);
		          }
		    	  
		    	  
		    	  output = "true";
		      
		    

		      conn.close();
		   }
		   
		   catch(SQLException e){
			   output = "false";
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			   output = "false";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return jsonArray;
	   }
	   
	   
	   
	   
	   
	   
}
