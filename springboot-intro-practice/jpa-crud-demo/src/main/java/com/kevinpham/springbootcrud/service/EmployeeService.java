package com.kevinpham.springbootcrud.service;

import java.util.List;

import com.kevinpham.springbootcrud.entity.Employee;

public interface EmployeeService {

		// Return list of all employees
		public List<Employee> findAll();
		
		// Find an employee by their ID
		public Employee findById(int theId);
		
		// Save an employee to database
		public void save(Employee theEmployee);
		
		// Save an employee by their ID
		public void deleteById(int theId);
}
