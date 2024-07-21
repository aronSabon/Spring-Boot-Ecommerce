package com.broadway.springbootEMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.broadway.springbootEMS.model.Department;
import com.broadway.springbootEMS.service.DepartmentService;
import com.broadway.springbootEMS.utils.DepartmentExcelView;
import com.broadway.springbootEMS.utils.DepartmentPdfView;

@Controller
public class DepartmentController {
	@Autowired
DepartmentService ds;
	@GetMapping("/departmentForm")
	private String getDepartmentForm() {
		return"DepartmentForm";
	}
	@PostMapping("/departmentForm")
	private String postDepartmentForm(@ModelAttribute Department department) {
		ds.addDepartment(department);
		return"DepartmentForm";
	}
	@GetMapping("/departmentList")
	private String getDepartmentList(Model model) {
		model.addAttribute("dList" , ds.getAllDepartment());
		return "DepartmentList";
	}
	@GetMapping("/edit/department")
	private String editDepartment(@RequestParam int id, Model model) {
		model.addAttribute("dModel", ds.getDepartmentById(id));
		return "DepartmentEdit";
	}
	@GetMapping("/delete/department")
	private String deleteDepartment(Model model,@RequestParam int id) {
		ds.deleteDepartment(id);
		return "redirect:/departmentList";
	}
	@PostMapping("/update/department")
	private String updateDepartment(@ModelAttribute Department department) {
		ds.updateDepartment(department);
		return"redirect:/departmentList";
	}
	@GetMapping("/dept/excel")
	public  ModelAndView excel() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("dList", ds.getAllDepartment());
		mv.setView(new DepartmentExcelView());
		return mv;
	}
	@GetMapping("/dept/pdf")
	public ModelAndView pdf() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("dList", ds.getAllDepartment());
		mv.setView(new DepartmentPdfView());
		return mv;
	}
}















