package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Oppurtunity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oppId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="email")
	private User user;
	
	private String location;
	private String skill;
	private String department;
	private String hiringManager;
	private String startDate;
	private String endDate;
	private int experience;
	private String description;
	
	public Oppurtunity() {}

	public int getOppId() {
		return oppId;
	}

	public void setOppId(int oppId) {
		this.oppId = oppId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHiringManager() {
		return hiringManager;
	}

	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Oppurtunity [oppId=" + oppId + ", user=" + user + ", location=" + location + ", skill=" + skill
				+ ", department=" + department + ", hiringManager=" + hiringManager + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", experience=" + experience + ", description=" + description + "]";
	}
	
	/*
	 * {
    "user" : {
        "email" : "abc"
    },
    "location":"bang",
    "skill" : "sk",
    "department" : "frontend",
    "hiringManager" : "suresh",
    "startDate" : "7/7/2021",
    "endDate" : "8/7/2021",
    "experience" : 3,
    "description":"desc"
}
	 */
	
}
