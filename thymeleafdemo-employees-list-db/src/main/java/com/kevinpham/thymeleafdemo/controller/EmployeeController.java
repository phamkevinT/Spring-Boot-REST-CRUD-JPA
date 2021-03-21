package com.kevinpham.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kevinpham.thymeleafdemo.entity.Employee;
import com.kevinpham.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	// Constructor injection
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//  add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// Get the employees from the database
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to spring model
		theModel.addAttribute("employees", theEmployees);
		
		// return the thymleaf html template view
		return "list-employees";
	}
	
}
