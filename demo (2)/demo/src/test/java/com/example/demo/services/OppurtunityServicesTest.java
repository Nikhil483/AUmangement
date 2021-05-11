package com.example.demo.services;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.OppurtunityRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Oppurtunity;
import com.example.demo.model.User;
import com.example.demo.service.OppurtunityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.Mockito.times;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OppurtunityServicesTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private OppurtunityService oppService;

	@MockBean
	private OppurtunityRepository oppRepository;

	@MockBean
	private UserRepository userRepository;

	static Logger log = LoggerFactory.getLogger(OppurtunityServicesTest.class);

	@Test
	public void addOppurtunity() throws Exception {

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

		Oppurtunity opp2 = new Oppurtunity();
		User user2 = new User();

		user2.setEmail("abc@gmail.com");
		user2.setName("abc");
		user2.setPhotoUrl("http://ert.png");

		opp2.setOppId(2);
		opp2.setUser(user2);
		opp2.setLocation("Chennai");
		opp2.setSkill("Manual testing");
		opp2.setDepartment("testing");
		opp2.setStartDate("1/7/2020");
		opp2.setEndDate("2/7/2020");
		opp2.setDescription("Description 1");
		opp2.setHiringManager("suresh");
		opp2.setExperience(5);

		List<User> LIST = new ArrayList<User>();
		LIST.add(user);
 
		when(oppRepository.findByOppId(1)).thenReturn(opp);
		when(userRepository.findByEmail(opp.getUser().getEmail())).thenReturn(LIST);

		when(oppRepository.save(opp)).thenReturn(opp);
		log.info(opp.toString());
		log.info(oppRepository.save(opp).toString());

		oppService.addOppurtunity(opp);
	}
}
