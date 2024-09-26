package com.broadway.springbootEMS.DTO;

import java.time.LocalDate;
import java.util.List;
import com.broadway.springbootEMS.model.Address;
import com.broadway.springbootEMS.model.Department;

public class EmployeeDTO {
		private int id;
		private String firstName;
		private String lastName;
		private String gender;
		private LocalDate dob;
		private String phone;
		private String email;
		private String company;
		private String post;
		private String salary;
		private LocalDate joinDate;
		private Address address;
//		private int departmentId;
		private Department department;
		List<String> projects;
		
}
