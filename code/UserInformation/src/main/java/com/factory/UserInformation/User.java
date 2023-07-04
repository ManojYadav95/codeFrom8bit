package com.factory.UserInformation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String username;
	
	private String password;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "roleId")
	private Role role;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "groupId")
	private Group1 group1;
	
	public User(UserRequest req)
	{
		this.username = req.getUsername();
		this.password = req.getPassword();
	}
	
	public User( ) {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Group1 getGroup1() {
		return group1;
	}

	public void setGroup1(Group1 group1) {
		this.group1 = group1;
	}

	public boolean isEnabled() {
		return true;
	}
}
