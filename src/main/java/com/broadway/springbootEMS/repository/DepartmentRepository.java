package com.broadway.springbootEMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springbootEMS.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	

}
