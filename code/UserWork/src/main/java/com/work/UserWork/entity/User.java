package com.work.UserWork.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String username;
	
	private String role;
	
	private String todaywork;
	
	private String workdone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTodaywork() {
		return todaywork;
	}

	public void setTodaywork(String todaywork) {
		this.todaywork = todaywork;
	}

	public String getWorkdone() {
		return workdone;
	}

	public void setWorkdone(String workdone) {
		this.workdone = workdone;
	}
}
