/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.tmgr.rest.EndPoint;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Response;

import com.tmgr.rest.EndPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

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
	public void testregister(){
		Response result = service.register("randomusername", "taskid", "abc", "abc", "abc");

		assertEquals(200, result.getStatus());
		
	}
    
}
