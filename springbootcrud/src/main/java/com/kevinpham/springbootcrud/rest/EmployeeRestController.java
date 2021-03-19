package com.kevinpham.springbootcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	// add mapping for GET /employees/{employeeId} - get employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}

	
	// add mapping for POST /employee - add new employee
	@PostMapping("/employees") 
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// in case user pass an id in JSON... set id to 0 
		// this force a save of new item instead of update
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
}
