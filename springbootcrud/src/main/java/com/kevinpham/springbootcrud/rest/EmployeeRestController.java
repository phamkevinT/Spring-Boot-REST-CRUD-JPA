package com.kevinpham.springbootcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinpham.springbootcrud.entity.Employee;
import com.kevinpham.springbootcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	// inject EmployeeService
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// expose "/employee" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		// Delegate to EmployeeService class
		return employeeService.findAll();
	}

}
