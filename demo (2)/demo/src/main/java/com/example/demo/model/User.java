package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String email;
	private String name;
	private String photoUrl;
	
	public User() {
		super();
		this.email = "abc@gmail.com";
		this.name = "abc";
		this.photoUrl = "url";
	}
	
	public User(String email, String name, String photoUrl) {
		super();
		this.email = email;
		this.name = name;
		this.photoUrl = photoUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", photoUrl=" + photoUrl + "]";
	}
}
