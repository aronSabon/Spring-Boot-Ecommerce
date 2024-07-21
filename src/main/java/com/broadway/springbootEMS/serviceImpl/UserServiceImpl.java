package com.broadway.springbootEMS.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadway.springbootEMS.model.User;
import com.broadway.springbootEMS.repository.UserRepository;
import com.broadway.springbootEMS.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository ur;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		ur.save(user);
	}

	@Override
	public User loginUser(String un, String pw) {
		return ur.findByUsernameAndPassword(un, pw);
	}

	@Override
	public User doesUserExist(String un) {
		return ur.findByUsername(un);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return ur.findById(id);
	}   

}
