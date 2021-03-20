package com.kevinpham.springbootcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevinpham.springbootcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
