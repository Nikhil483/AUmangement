package com.example.demo.model.dto;

import java.util.HashMap;
import java.util.Map;

public class OppurnityByYearDto {

	public Map<String, Integer> OBYFrequency = new HashMap<String, Integer>();
	
	public void addOBYCount(String date) {
		String year = date.substring(0,4);
		boolean isKeyPresent = this.OBYFrequency.containsKey(year);
	      if(isKeyPresent){
	      	int currentCount = this.OBYFrequency.get(year);
			this.OBYFrequency.put(year, ++currentCount);
	      }
	      else {
	        this.OBYFrequency.put(year,1);
	      }
	}
}
