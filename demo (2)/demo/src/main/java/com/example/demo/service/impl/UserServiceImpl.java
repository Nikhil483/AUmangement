package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    UserRepository userRepository;
	
	public void addUser(User user) {
		List<User> currentUser = new ArrayList<>();
		int flag = 0;
		currentUser = userRepository.findAll();
		for(int i=0; i< currentUser.size(); i++ ) {
			if(currentUser.get(i).getEmail() == user.getEmail()) {
				flag=1;
				break;
			}
		}
		if(flag == 0) {
			userRepository.save(user);
		}
		return ;
	}
	
	@Override
	public Boolean checkUser(String email) {
		return (userRepository.findByEmail(email).size()==1);
	}

	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email).get(0);
	}

	
}
