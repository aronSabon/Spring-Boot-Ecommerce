package com.broadway.springbootEMS.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.broadway.springbootEMS.model.Department;
import com.broadway.springbootEMS.model.Employee;
import com.broadway.springbootEMS.service.DepartmentService;
@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from your Angular app

public class DepartmentRestController {
	@Autowired
	DepartmentService deptService;
	@PostMapping("/api/dept/add")
	//	public String add(@RequestBody Department dept) {
	public ResponseEntity<Map<String, Object>> add(@RequestBody Department dept) {
		deptService.addDepartment(dept);
		Map<String, Object> response = new HashMap<>();
		response.put("success", true);
		return ResponseEntity.ok(response);
		//		return "success";
	}
	@GetMapping("/api/dept/list")
	public List<Department> getAll() {
		return deptService.getAllDepartment();
	}
	
	@PostMapping("/api/dept/addd")
	public String addd(@RequestBody Department dept) {
		deptService.addDepartment(dept);
		return "success";
	}
	@GetMapping("/api/dept/{id}")
	public Department getOneDept(@PathVariable int id) {
		return deptService.getDepartmentById(id);
	}
}
