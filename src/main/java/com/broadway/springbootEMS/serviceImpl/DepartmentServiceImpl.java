package com.broadway.springbootEMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springbootEMS.model.Department;
import com.broadway.springbootEMS.repository.DepartmentRepository;
import com.broadway.springbootEMS.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
DepartmentRepository dr;
	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		dr.save(department);
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
	}

	@Override
	public Department getDepartmentById(@RequestParam int id) {
		// TODO Auto-generated method stub
		return dr.findById(id).get();
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		dr.save(department);
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}
	

}
