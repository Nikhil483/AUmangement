package com.example.demo.model.dto;

import java.util.*;

public class ManagerDto {

	public Map<String, Integer> managerFrequency = new HashMap<String, Integer>();
	
	public void addManagerCount(String name) {
		boolean isKeyPresent = this.managerFrequency.containsKey(name);
	      if(isKeyPresent){
	      	int currentCount = this.managerFrequency.get(name);
			this.managerFrequency.put(name, ++currentCount);
	      }
	      else {
	        this.managerFrequency.put(name,1);
	      }
	}
}
