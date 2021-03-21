package com.kevinpham.thymeleafdemo.controller;

/**
 * 
 * Controller class that takes care of GET and POST requests 
 * 
 */

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kevinpham.thymeleafdemo.entity.Employee;
import com.kevinpham.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	// mapping for "/list" --> Displays a table of employees in database
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from database
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		// return the thymeleaf view
		return "/employees/list-employees";
	}
	
	
	// mapping for "/showFormForAdd" --> displays the form for inserting new info for employee
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		// add the attributes to employee 
		theModel.addAttribute("employee", theEmployee);
		
		// return the thymeleaf view
		return "/employees/employee-form";
	}

	
	// mapping for "/showFormForUpdate" --> display form for updating current employee information
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form
		return "/employees/employee-form";			
	}
	
	
	// mapping for "/save" --> save the information on form
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	
	// mapping for "/delete" --> delete an existing employee
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		employeeService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/employees/list";
	}
	
	
	// mapping for "/search" --> search an employee by name
	@GetMapping("/search")
	public String delete(@RequestParam("employeeName") String theName, Model theModel) {
		
		// delete the employee
		List<Employee> theEmployees = employeeService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		// send to /employees/list
		return "/employees/list-employees";
	}
	
}


















