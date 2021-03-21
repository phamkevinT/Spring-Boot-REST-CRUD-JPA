package com.kevinpham.thymeleafdemo.dao;

/**
 * 
 * By extending JpaRepository, Spring Data JPA provides CRUD operations for free:
 * 		findAll()
 * 		findById()
 * 		save()
 * 		deleteById()
 * 		...
 * 
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevinpham.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// add a method to sort by last name
	// Spring Data JPA will parse the method name for create a query statement
	// find all by ... order by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
	// search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
