package com.example.demo.model.dto;

import java.util.*;

public class SkillDto {

	public Map<String, Integer> skillFrequency = new HashMap<String, Integer>();
	
	public void addSkillCount(String name) {
		boolean isKeyPresent = this.skillFrequency.containsKey(name);
	      if(isKeyPresent){
	      	int currentCount = this.skillFrequency.get(name);
			this.skillFrequency.put(name, ++currentCount);
	      }
	      else {
	        this.skillFrequency.put(name,1);
	      }
	}
}
