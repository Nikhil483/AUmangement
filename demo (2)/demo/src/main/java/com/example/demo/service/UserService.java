package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
	void addUser(User user);
	Boolean checkUser(String email);
	User getUser(String email);
}
