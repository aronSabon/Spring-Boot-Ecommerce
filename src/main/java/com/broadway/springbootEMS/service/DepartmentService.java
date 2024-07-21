package com.broadway.springbootEMS.service;

import java.util.List;

import com.broadway.springbootEMS.model.Department;

public interface DepartmentService {
void addDepartment(Department department);
void deleteDepartment(int id);
Department getDepartmentById(int id);
void updateDepartment(Department department);
List<Department> getAllDepartment();
}
