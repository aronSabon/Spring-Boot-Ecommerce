package com.broadway.springbootEMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadway.springbootEMS.model.Employee;
import com.broadway.springbootEMS.repository.EmployeeRepository;
import com.broadway.springbootEMS.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
EmployeeRepository er;
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		er.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return er.findById(id).get();
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		er.save(employee);
	}

}
