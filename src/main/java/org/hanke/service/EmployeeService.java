package org.hanke.service;

import java.util.Collection;

import org.hanke.model.Employee;

public interface EmployeeService {
	
	Collection<Employee> findAll();
	
	Employee findOne(Long id);
	
	Employee create(Employee employee);
	
	Employee update(Employee employee);
	
	void delete(Long id);
}
