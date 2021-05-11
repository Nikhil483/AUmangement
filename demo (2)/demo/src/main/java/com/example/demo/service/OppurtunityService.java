package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Oppurtunity;
import com.example.demo.model.dto.LocationDto;
import com.example.demo.model.dto.ManagerDto;
import com.example.demo.model.dto.OppurnityByYearDto;
import com.example.demo.model.dto.SkillDto;

public interface OppurtunityService {

	Oppurtunity addOppurtunity(Oppurtunity opp);
	List<Oppurtunity> getAll();
	String deleteBy(Integer keyword);
	Oppurtunity getOppurtunity(int keyword);
	
	SkillDto getSkillFrequency();
	LocationDto getLocationFrequency();
	ManagerDto getManagerFrequency();
	OppurnityByYearDto getOppurtunityFrequency();
}
