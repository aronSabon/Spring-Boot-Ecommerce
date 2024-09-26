package com.broadway.springbootEMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springbootEMS.model.Address;
import com.broadway.springbootEMS.model.Employee;
import com.broadway.springbootEMS.service.DepartmentService;
import com.broadway.springbootEMS.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	DepartmentService ds;
	@Autowired
	EmployeeService es;
	@GetMapping("/employeeForm")
	private String getEmployee(Model model){
		model.addAttribute("dList", ds.getAllDepartment());
		return"EmployeeForm";
	}

	@PostMapping("/employeeForm")
	private String postEmployee(@ModelAttribute Employee employee, @ModelAttribute Address address){
		es.addEmployee(employee);
		return"redirect:/employeeForm";
	}
	@GetMapping("/employeeList")
	private String employeeList(Model model){
		
		model.addAttribute("eList", es.getAllEmployee());
		return"EmployeeList";
	}

	@GetMapping("/edit/employee")
	private String editEmployee(@RequestParam int id,Model model){
		model.addAttribute("eModel", es.getEmployeeById(id));
		model.addAttribute("dList", ds.getAllDepartment());
		return"EmployeeEdit";
	}

	@GetMapping("/delete/employee")
	private String deleteEmployee(@RequestParam int id){
		es.deleteEmployeeById(id);
		return"redirect:/employeeList";
	}
	@PostMapping("/update/employee")
	private String updateEmployee(@ModelAttribute Employee employee){
		es.updateEmployee(employee);
		return"redirect:/employeeList";
	}
}
