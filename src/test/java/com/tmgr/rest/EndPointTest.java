package com.tmgr.rest;

import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author huliv
 */
public class EndPointTest {
    private static EndPoint service;

	@BeforeClass
	public static void initEndPoint() {
		service = new EndPoint();
	}

	@Before
	public void beforeEachTest() {
		System.out.println("This is executed before each Test");
	}

	@After
	public void afterEachTest() {
		System.out.println("This is exceuted after each Test");
	}
        
        @Test
	public void testregister(){
		Response result = service.register("randomusername", "taskid", "abc", "abc", "abc");

		assertEquals(200, result.getStatus());
		
	}

	@Test
	public void testLogin() {
		Response result = service.authenticate("randomusername", "randompassword");

		assertEquals(200, result.getStatus());
	}
	
	@Test
	public void testTask(){
		Response result = service.gettask("randomusername");

		assertEquals(200, result.getStatus());
		
	}
	
	@Test
	public void testCompletedTask(){
		Response result = service.getcompletedtask("randomusername");

		assertEquals(200, result.getStatus());
		
	}
	
	@Test
	public void testgetuser(){
		Response result = service.getUser("randomusername");

		assertEquals(200, result.getStatus());
		
	}
        
        
        
        @Test
	public void testmarkcomplete(){
		Response result = service.markcomplete("randomusername", "47");

		assertEquals(200, result.getStatus());
		
	}
	
	@Test
	public void testdeletetask(){
		Response result = service.deletetask("randomusername", "47");

		assertEquals(200, result.getStatus());
		
	}
        
        @Test
	public void testsavetask(){
		Response result = service.savetask("randomusername", "randomTitle", "randomMessage", "03/08/2014", "High");

		assertEquals(200, result.getStatus());
		
	}
        
        @Test
	public void testupdatetask(){
		Response result = service.updatetask("47", "randomusername", "randomTitle", "randomMessage", "03/08/2014", "High", "0");

		assertEquals(200, result.getStatus());
		
	}
}
