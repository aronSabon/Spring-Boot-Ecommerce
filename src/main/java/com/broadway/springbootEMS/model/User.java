package com.broadway.springbootEMS.model;

import com.broadway.springbootEMS.contants.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String firstName;
private String lastName;
private String username;
private String password;
private Role role;
}
