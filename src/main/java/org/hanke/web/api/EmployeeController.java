package org.hanke.web.api;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hanke.model.Employee;
import org.hanke.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(
			value="/api/employees", 
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployees() {
		
		Collection<Employee> employees = employeeService.findAll();
		return new ResponseEntity<Collection<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/employees/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		
		Employee employee = employeeService.findOne(id);
		
		if(employee == null) {
			System.out.println("Not here");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "api/employees", 
			method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		Employee savedEmployee = employeeService.create(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(
			value = "api/employees/{id}", 
			method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.update(employee);
		if(updatedEmployee == null) {
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "api/employees/{id}",
			method=RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(
			value = "logout",
			method=RequestMethod.GET)
	public String logout() {

		return "SEUFHEWF";
	}
	
}
