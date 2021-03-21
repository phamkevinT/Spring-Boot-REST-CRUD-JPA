package com.kevinpham.thymeleafdemo.controller;

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

/**
 * 
 * Takes care of all request to path /employees
 *
 */

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	
	// Constructor injection
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	

	// mapping for "/list" --> Show table of existing employee from database
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// Get the employees from the database
		List<Employee> theEmployees = employeeService.findAll();

		// add to spring model
		theModel.addAttribute("employees", theEmployees);

		// return the thymeleaf html template view
		return "employees/list-employees";
	}

	
	// mapping for "/showFormForAdd" --> Show form for adding new employee to database
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		// add to spring model
		theModel.addAttribute("employee", theEmployee);
		
		// return the template view
		return "employees/employee-form";
	}
	
	
	// mapping for "/save" --> Save a new employee to database
	// 'employee' refers to form data passed in using data binding
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute ("employee") Employee theEmployee) {
		
		// save the employee
		employeeService.save(theEmployee);
		
		// use redirect to prevent duplicate submissions from reloading browser
		return "redirect:/employees/list";
	}
	
	
	// mapping for "/showFormForUpdate" --> Update an existing employee's information
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get the employee from the EmployeeService
		Employee theEmployee = employeeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form
		return "employees/employee-form";
		
	}
	
	
	// mapping for "/showFormForUpdate" --> Update an existing employee's information
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		employeeService.deleteById(theId);
		
		// redirect to employees/list
		return "redirect:/employees/list";
		
	}
}
