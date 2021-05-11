package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.dao.OppurtunityRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.enums.Role;
import com.example.demo.model.User;
import com.example.demo.model.dto.AccessTokenDto;
import com.example.demo.security.IJwtTokenProviderService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository userRepository;

	@Autowired
	IJwtTokenProviderService jwtTokenProviderService;

	@Autowired
	private ObjectMapper objectMapper;

	String url = "/api/auth/";

	@MockBean
	private OppurtunityRepository opp;

	static Logger log = LoggerFactory.getLogger(UserControllerTest.class);

	@Test
	public void Success() throws Exception {
		User user = new User();
		user.setEmail("abc@gmail.com");
		user.setName("naveen");
		user.setPhotoUrl("http");

		User resUser = new User();
		resUser.setEmail("abc@gmail.com");
		user.setName("naveen");
		user.setPhotoUrl("http");

		List<User> users = new ArrayList<User>();
		users.add(resUser);

		String token = jwtTokenProviderService.createToken(user.getEmail(), Role.ROLE_ADMIN);

		AccessTokenDto dtoToken = new AccessTokenDto();
		dtoToken.setAccessToken(jwtTokenProviderService.createToken(user.getEmail(), Role.ROLE_ADMIN));
		dtoToken.setEmail(user.getEmail());
		when(userRepository.findByEmail("abc@gmail.com")).thenReturn(users);

		MvcResult mvcResult = mockMvc.perform(post("/api/unauth/login").contentType("application/json")
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isOk()).andReturn();
		System.out.print(token);

	}

}
