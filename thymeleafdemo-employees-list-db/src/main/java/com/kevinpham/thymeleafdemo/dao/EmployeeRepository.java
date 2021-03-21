package com.kevinpham.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevinpham.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
