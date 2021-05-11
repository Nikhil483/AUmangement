package com.example.demo.controller;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.dao.OppurtunityRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Oppurtunity;
import com.example.demo.model.User;
import com.example.demo.security.IJwtTokenProviderService;
import com.example.demo.service.OppurtunityService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser("spring")
public class OppurtunityControllerTest {

	@MockBean
	IJwtTokenProviderService jwtTokenProviderService;

	@MockBean
	OppurtunityService oppService;

	@MockBean
	private OppurtunityRepository oppRepository;

	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository userRepository;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	static Logger log = LoggerFactory.getLogger(UserControllerTest.class);
	String url = "/api/auth/";
	
	@Test
	public void Update() throws Exception {
		Oppurtunity opp = new Oppurtunity();
		User user = new User();

		user.setEmail("abc@gmail.com");
		user.setName("abc");
		user.setPhotoUrl("http://ert.png");

		opp.setOppId(1);
		opp.setUser(user);
		opp.setLocation("Chennai");
		opp.setSkill("Manual testing");
		opp.setDepartment("testing");
		opp.setStartDate("1/7/2020");
		opp.setEndDate("2/7/2020");
		opp.setDescription("Description 1");
		opp.setHiringManager("suresh");
		opp.setExperience(5);
		
		when(oppService.getOppurtunity(1)).thenReturn(opp);
		
		MvcResult mvcResultClient = mockMvc.perform(put("/api/auth/updateOppurtunity").contentType("application/json")
				.content(objectMapper.writeValueAsString(opp))).andExpect(status().isOk()).andReturn();
		
		System.out.println(mvcResultClient.getResponse());
		System.out.println(opp);
	}

	@Test
	public void getOppurtunitiesWhenOk() throws Exception {

		List<Oppurtunity> oppurtunities = new ArrayList<Oppurtunity>();
		oppurtunities.add(new Oppurtunity());
		when(oppRepository.findAll()).thenReturn(oppurtunities);
		when(oppService.getAll()).thenReturn(oppurtunities);
		MvcResult mvcResultClient = mockMvc.perform(get("/api/auth/getAllOppurtunity").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

	}

	@Test
	public void Delete() throws Exception {
		MvcResult mvcResultClient = mockMvc
				.perform(delete("/api/auth/deleteOppurtunity/5").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();

	}

	@Test
	public void Add() throws Exception {
		Oppurtunity opp = new Oppurtunity();
		User user = new User();

		user.setEmail("abc@gmail.com");
		user.setName("abc");
		user.setPhotoUrl("http://ert.png");

		opp.setUser(user);
		opp.setLocation("Chennai");
		opp.setSkill("Manual testing");
		opp.setDepartment("testing");
		opp.setStartDate("1/7/2020");
		opp.setEndDate("2/7/2020");
		opp.setDescription("Description 1");
		opp.setHiringManager("suresh");
		opp.setExperience(5);
		MvcResult mvcResultClient = mockMvc.perform(post("/api/auth/addOppurtunity").contentType("application/json")
				.content(objectMapper.writeValueAsString(opp))).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void Trends() throws Exception {
		
		List<Oppurtunity> oppList = new ArrayList<Oppurtunity>(); 
		when(oppService.getAll()).thenReturn(oppList);

		MvcResult mvcResultSkill = mockMvc.perform(get("/api/auth/getSkillFrequency").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();
		
		MvcResult mvcResultLocation = mockMvc
				.perform(get("/api/auth/getLocationFrequency").contentType("application/json")).andExpect(status().isOk())
				.andReturn();
		
		MvcResult mvcResultManager = mockMvc.perform(get("/api/auth/getManagerFrequency").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();
		
		MvcResult mvcResultYear = mockMvc.perform(get("/api/auth/getOppurnityByYear").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();
	}

}
