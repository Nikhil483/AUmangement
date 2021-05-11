package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User,String>{
	List<User> findByEmail(String email);
}
