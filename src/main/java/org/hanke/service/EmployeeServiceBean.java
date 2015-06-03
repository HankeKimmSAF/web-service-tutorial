package org.hanke.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hanke.model.Employee;
import org.hanke.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceBean implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Collection<Employee> findAll() {
		Collection<Employee> employees = (Collection<Employee>) employeeRepository.findAll();		
		return employees;
	}

	@Override
	public Employee findOne(Long id) {
		Employee employee = employeeRepository.findOne(id);
		return employee;
	}

	@Override
	public Employee create(Employee employee) {
		if (employee.getId() != null) {
			return null;
		}
		Employee newEmployee = employeeRepository.save(employee);
		return newEmployee;
	}
	
	@Override
	public Employee update(Employee employee) {
		Employee employeePersisted = employeeRepository.findOne(employee.getId()); 
		if(employeePersisted == null) {
			return null;
		}
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}
	
	@Override
	public void delete(Long id) {
		employeeRepository.delete(id);
	}	
}