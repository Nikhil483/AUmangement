package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.OppurtunityRepository;
import com.example.demo.model.Oppurtunity;
import com.example.demo.model.dto.LocationDto;
import com.example.demo.model.dto.ManagerDto;
import com.example.demo.model.dto.OppurnityByYearDto;
import com.example.demo.model.dto.SkillDto;
import com.example.demo.service.OppurtunityService;

@Service
@Transactional
public class OppurtunityServiceImpl implements OppurtunityService{

	@Autowired
	OppurtunityRepository oppRepository;

	@Override
	public Oppurtunity addOppurtunity(Oppurtunity opp) {
		return oppRepository.save(opp);
	}

	@Override
	public List<Oppurtunity> getAll() {
		return oppRepository.findAll();
	}
	
	@Override
	public String deleteBy(Integer id) {
		oppRepository.deleteById(oppRepository.findByOppId(id).getOppId());
		return "deletion succuessfull";
	}
	
	@Override
	public Oppurtunity getOppurtunity(int oppId) {
		System.out.println("dcDSCS"+oppId);
		return oppRepository.findByOppId(oppId);
	}
	
	@Override
	public SkillDto getSkillFrequency() {
		List<Oppurtunity> oppurtunities = oppRepository.findAll();
		SkillDto skillDto = new SkillDto();
		for(int i=0; i< oppurtunities.size(); i++ ) {
			skillDto.addSkillCount(oppurtunities.get(i).getSkill());
		}
		return skillDto;
	}
	
	@Override
	public LocationDto getLocationFrequency() {
		List<Oppurtunity> oppurtunities = oppRepository.findAll();
		LocationDto locationDto = new LocationDto();
		for(int i=0; i< oppurtunities.size(); i++ ) {
			locationDto.addLocationCount(oppurtunities.get(i).getLocation());
		}
		return locationDto;
	}
	
	@Override
	public ManagerDto getManagerFrequency() {
		List<Oppurtunity> oppurtunities = oppRepository.findAll();
		ManagerDto managerDto = new ManagerDto();
		for(int i=0; i< oppurtunities.size(); i++ ) {
			managerDto.addManagerCount(oppurtunities.get(i).getHiringManager());
		}
		return managerDto;
	}
	
	@Override
	public OppurnityByYearDto getOppurtunityFrequency() {
		List<Oppurtunity> oppurtunities = oppRepository.findAll();
		OppurnityByYearDto obyDto = new OppurnityByYearDto();
		for(int i=0; i< oppurtunities.size(); i++ ) {
			obyDto.addOBYCount(oppurtunities.get(i).getStartDate());
		}
		return obyDto;
	}
}
