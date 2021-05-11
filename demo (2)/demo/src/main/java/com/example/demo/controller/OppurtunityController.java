package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.OppurtunityRepository;
import com.example.demo.model.Oppurtunity;
import com.example.demo.model.User;
import com.example.demo.service.OppurtunityService;
import com.example.demo.model.dto.LocationDto;
import com.example.demo.model.dto.ManagerDto;
import com.example.demo.model.dto.OppurnityByYearDto;
import com.example.demo.model.dto.SkillDto;
import com.example.demo.service.OppurtunityService;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OppurtunityController {
	
	@Autowired
	OppurtunityService oppService;
	
	@Autowired
	OppurtunityRepository oppRepository;

	@PostMapping(path = "/api/auth/addOppurtunity")
	public ResponseEntity<Oppurtunity> addOppurtunity(@RequestBody Oppurtunity oppBody) {
		return new ResponseEntity<>(oppService.addOppurtunity(oppBody), HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/auth/getAllOppurtunity")
	public ResponseEntity<List<Oppurtunity>> getAllOppurtunity() {
		List<Oppurtunity> allOpurtunities = null;
		allOpurtunities = oppService.getAll();
		if(allOpurtunities.size()>0)
			return new ResponseEntity<>(allOpurtunities, HttpStatus.OK);
		return new ResponseEntity<>(allOpurtunities, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
	}
	
	@GetMapping(path = "/api/auth/getOppurtunity/{oppId}")
	public ResponseEntity<Oppurtunity> getOppurtunity(@PathVariable("oppId") Integer oppId) {
		Oppurtunity allOpurtunities = null;
		allOpurtunities = oppService.getOppurtunity(oppId);
		return new ResponseEntity<>(allOpurtunities, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/api/auth/deleteOppurtunity/{oppId}")
	public ResponseEntity<String>  deleteBy(@PathVariable("oppId") Integer oppId) {
		System.out.println("controller");
		String status = oppService.deleteBy(oppId);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@PutMapping(path = "/api/auth/updateOppurtunity")
	public ResponseEntity<String> updateOppurtunity(@RequestBody Oppurtunity oppBody) {
		System.out.println(oppBody);
		Oppurtunity opp = oppService.getOppurtunity(oppBody.getOppId());
		
		opp.setLocation(oppBody.getLocation());
		opp.setUser(oppBody.getUser());
		opp.setSkill(oppBody.getSkill());
		opp.setDepartment(oppBody.getDepartment());
		opp.setHiringManager(oppBody.getHiringManager());
		opp.setStartDate(oppBody.getStartDate());
		opp.setEndDate(oppBody.getEndDate());
		opp.setExperience(oppBody.getExperience());

		oppService.addOppurtunity(opp);
		return new ResponseEntity<>("oppurtunity updated successfully", HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/auth/getSkillFrequency")
	public ResponseEntity<Map<String, Integer>> getSkillFrequency() {
		SkillDto obj = oppService.getSkillFrequency();
		return new ResponseEntity<>(obj.skillFrequency, HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/auth/getLocationFrequency")
	public ResponseEntity<Map<String, Integer>> getLocationFrequency() {
		LocationDto obj = oppService.getLocationFrequency();
		return new ResponseEntity<>(obj.locationFrequency, HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/auth/getManagerFrequency")
	public ResponseEntity<Map<String, Integer>> getManagerFrequency() {
		ManagerDto obj = oppService.getManagerFrequency();
		return new ResponseEntity<>(obj.managerFrequency, HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/auth/getOppurnityByYear")
	public ResponseEntity<Map<String, Integer>> getoppurtunityFrequency() {
		OppurnityByYearDto obj = oppService.getOppurtunityFrequency();
		return new ResponseEntity<>(obj.OBYFrequency, HttpStatus.OK);
	}
}
