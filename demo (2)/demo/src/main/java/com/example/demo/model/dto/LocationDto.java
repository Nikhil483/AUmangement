package com.example.demo.model.dto;

import java.util.*;

public class LocationDto {

	public Map<String, Integer> locationFrequency = new HashMap<String, Integer>();
	
	public void addLocationCount(String name) {
		boolean isKeyPresent = this.locationFrequency.containsKey(name);
	      if(isKeyPresent){
	      	int currentCount = this.locationFrequency.get(name);
			this.locationFrequency.put(name, ++currentCount);
	      }
	      else {
	        this.locationFrequency.put(name,1);
	      }
	}
}
