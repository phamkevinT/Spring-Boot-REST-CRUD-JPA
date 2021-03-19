package com.kevinpham.springbootcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinpham.springbootcrud.dao.EmployeeDAO;
import com.kevinpham.springbootcrud.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDAO employeDAO;
	
	// inject EmployeeDAO
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeDAO = theEmployeeDAO;
	}
	
	// expose "/employee" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		// Delegate to EmployeeDAO class
		return employeDAO.findAll();
	}
	
}
