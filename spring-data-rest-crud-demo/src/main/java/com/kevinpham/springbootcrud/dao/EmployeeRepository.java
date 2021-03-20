package com.kevinpham.springbootcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kevinpham.springbootcrud.entity.Employee;

// @RepositoryRestResource(path="members") // Alternative path otherwise default is Employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
