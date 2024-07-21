package com.broadway.springbootEMS.service;

import java.util.List;

import com.broadway.springbootEMS.model.Employee;

public interface EmployeeService {
void addEmployee(Employee employee);
List<Employee> getAllEmployee();
void deleteEmployeeById(int id);
Employee getEmployeeById(int id);
void updateEmployee(Employee employee);


}
