package com.kevinpham.springbootcrud.dao;

import java.util.List;

import com.kevinpham.springbootcrud.entity.Employee;

public interface EmployeeDAO {

	// Return list of all employees
	public List<Employee> findAll();
}
