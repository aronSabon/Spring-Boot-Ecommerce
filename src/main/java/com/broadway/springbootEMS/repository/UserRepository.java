package com.broadway.springbootEMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springbootEMS.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
User findByUsernameAndPassword(String un,String pw);
User findByUsername(String un);
User findById(int id);

}
