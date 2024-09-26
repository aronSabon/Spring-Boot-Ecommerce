package com.broadway.springbootEMS.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.broadway.springbootEMS.model.Employee;
import com.broadway.springbootEMS.model.Employee;
import com.broadway.springbootEMS.model.Product;
import com.broadway.springbootEMS.repository.ProductRepository;
import com.broadway.springbootEMS.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from your Angular app

public class EmployeeRestController {
	
	@Autowired   
	private EmployeeService empService;  
	
	@PostMapping("/api/employee/add")
	//	public String add(@RequestBody Employee dept) {
	public ResponseEntity<Map<String, Object>> add(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		Map<String, Object> response = new HashMap<>();
		response.put("success", true);
		return ResponseEntity.ok(response);
		//		return "success";
	}
	@GetMapping("/api/employee/list")
	public List<Employee> getAll() {
		return empService.getAllEmployee();
	}
	
	
	
	@Autowired
	private ProductRepository pr;
//	
//	@GetMapping("/api/emp/list")
//	public List<Employee> getAll() {
//		return empService.getAllEmployee();
//	}
	@GetMapping("/api/emp/{id}")
	public Employee getOneEmp(@PathVariable int id) {
		return empService.getEmployeeById(id);
	}
	@PostMapping("/api/employee/addd")
	public String addd(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		return "success";
	}
//	@DeleteMapping("/api/emp/delete/{id}")
//	public String delete(@PathVariable int id) {
//		empService.deleteEmployeeById(id);
//		return "success";
//	}
//	@PutMapping("/api/emp/update")
//	public String update(@RequestBody Employee emp) {
//		empService.updateEmployee(emp);
//		return "Success";
//	}
//	@GetMapping("/api/emp/j2o")
//	public String jsonToObject() {
//		RestTemplate rest= new RestTemplate();
//		Employee emp =rest.getForObject("http://localhost:8080/api/emp/6", Employee.class);
//		
////		return"FirstName= "+ emp.getFirstName();
//		return null;
//	}
//	@GetMapping("/api/emp/ja2oa")
//	public String jsonArrayToObjArray() {
//		RestTemplate rest = new RestTemplate();
//		Employee[] emps = rest.getForObject("http://localhost:8080/api/emp/list", Employee[].class);
////		return "Name= "+emps[0].getFirstName()+" "+emps[0].getLastName();
//		return null;
//	}
//	//     localhost:8080/api/emp/pload        use this url when using the application for first time
	@GetMapping("/api/emp/pload")
	public String loadProducts() {
		RestTemplate rest= new RestTemplate();
		Product[] products =rest.getForObject("https://fakestoreapi.com/products", Product[].class);
		pr.saveAll(List.of(products));
		return "success";
	}
}








