package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.dao.UserRepository;
import com.example.demo.enums.Role;
import com.example.demo.model.User;
import com.example.demo.model.dto.AccessTokenDto;
import com.example.demo.service.OppurtunityService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtTokenTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private JwtTokenProviderService jwtTokenProviderService;

	static Logger log = LoggerFactory.getLogger(JwtTokenTest.class);

	@Test
	public void LoadingUser() throws Exception {

		UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername("abc@gmail.com")
                .password("7795453566")
                .authorities(Role.ROLE_ADMIN)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setEmail("abc@gmail.com");
		user.setName("naveen");
		user.setPhotoUrl("http");
		userList.add(user);
		when(userRepository.findByEmail("abc@gmail.com")).thenReturn(userList);
		assertEquals(userDetailsService.loadUserByUsername("abc@gmail.com"), user);
	}
}
