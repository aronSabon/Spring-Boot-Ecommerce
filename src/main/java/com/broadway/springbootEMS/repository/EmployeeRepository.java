package com.broadway.springbootEMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springbootEMS.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
