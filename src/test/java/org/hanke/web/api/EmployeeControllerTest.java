package org.hanke.web.api;

import org.hanke.AbstractControllerTest;
import org.hanke.model.Employee;
import org.hanke.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class EmployeeControllerTest extends AbstractControllerTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testGetEmployees() throws Exception {
		String uri = "/api/employees";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);
	}
	
	@Test
	public void testGetEmployee() throws Exception {
		String uri = "/api/employees/{id}";
		Long id = new Long(1);

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, id).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		
		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);
	}
	
	@Test
	public void testGetEmployeeNotFound() throws Exception {
		String uri = "api/employees/{id}";
		Long id = Long.MAX_VALUE;
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, id).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		
		Assert.assertEquals("failure - expected HTTP status 404", 404, status);
		Assert.assertTrue("failure - epected HTTP response body to be empty", content.trim().length() == 0);		
	}
	
	@Test
	public void testCreateEmployee() throws Exception {		
		String uri = "/api/employees";
		/*Employee employee = new Employee();
		employee.setFirstName("Blanke");
		employee.setLastName("Spanky");*/
		//String inputJson = mapToJson(employee);
		
		//MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		
		//String content = result.getResponse().getContentAsString();
		//int status = result.getResponse().getStatus();
		
		//Assert.assertEquals("failure - expected HTTP status 201", 201, status);
		//Assert.assertTrue(inputJson, content.trim().length() > 0);
		
		//Employee createdEmployee = mapFromJson(content, Employee.class);		
	}
}