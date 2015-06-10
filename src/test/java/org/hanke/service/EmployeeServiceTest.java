package org.hanke.service;

import java.util.Collection;

import org.hanke.AbstractTest;
import org.hanke.model.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EmployeeServiceTest extends AbstractTest {
	
	@Autowired
	private EmployeeService service;
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testFindAll() {
		Collection<Employee> list = service.findAll();
		Assert.assertNotNull("failure - expected not null", list);
		Assert.assertEquals("failure - expected size", 3, list.size());
	}
}