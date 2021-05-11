package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enums.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import com.example.demo.model.dto.EmailDto;
import com.example.demo.model.dto.AccessTokenDto;

import com.example.demo.security.IJwtTokenProviderService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	private IJwtTokenProviderService jwtTokenProviderService;

	@PostMapping(path = "/api/addUser")
	public ResponseEntity<String> addUser(@RequestBody User userBody) {
		
		userService.addUser(userBody);
		return new ResponseEntity<>("account handled", HttpStatus.OK);

	}
	
	@PostMapping(path = "/api/auth/userExists")
	public ResponseEntity<String> checkUserExists(@RequestBody EmailDto emailDTO) {

		if (userService.checkUser(emailDTO.getEmail()))
			return new ResponseEntity<>("Yes User Exists", HttpStatus.OK);
		return new ResponseEntity<>("User Does'not Exist", HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "/api/unauth/login")
	public ResponseEntity<AccessTokenDto> checkUser(@RequestBody User userBody) {
		
		userService.addUser(userBody);
		User user = userService.getUser(userBody.getEmail());
		if (user == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		AccessTokenDto l = new AccessTokenDto();
		l.setAccessToken(jwtTokenProviderService.createToken(user.getEmail(), Role.ROLE_ADMIN));
		l.setEmail(user.getEmail());
		System.out.println(l);
		return new ResponseEntity<>(l, HttpStatus.OK);

	}

}
