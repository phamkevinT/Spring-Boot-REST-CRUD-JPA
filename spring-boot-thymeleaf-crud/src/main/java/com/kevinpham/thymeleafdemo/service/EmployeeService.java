package com.kevinpham.thymeleafdemo.service;

import java.util.List;

import com.kevinpham.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	// get all employees from database
	public List<Employee> findAll();
	
	// find an employee by id
	public Employee findById(int theId);
	
	// save an employee to database
	public void save(Employee theEmployee);
	
	// delete an employee given their id
	public void deleteById(int theId);

	// search an employee by name
	public List<Employee> searchBy(String theName);
	
}
