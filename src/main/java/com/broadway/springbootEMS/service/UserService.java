package com.broadway.springbootEMS.service;

import com.broadway.springbootEMS.model.User;

public interface UserService {
	public void addUser(User user);
	public User loginUser(String un, String pw);
	public User doesUserExist(String un);
	User getUserById(int id);
}
