package com.broadway.springbootEMS.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data@Entity
public class Employee {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	private String firstName;
	private String lastName;
	private String gender;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;
	private String phone;
	private String email;
	private String company;
	private String post;
	private String salary;
	@DateTimeFormat(iso =  ISO.DATE)
	private LocalDate joinDate;
	@Cascade(CascadeType.ALL)
	@OneToOne
	private Address address;
	
//	@ManyToOne
//	@JoinColumn(name = "deptid")
	private int departmentId;
//	List<Department> department;
	
	@ElementCollection
	@CollectionTable
	List<String> projects;
	
}
