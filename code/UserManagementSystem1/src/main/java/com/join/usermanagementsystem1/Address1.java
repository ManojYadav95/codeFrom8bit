package com.join.usermanagementsystem1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address1 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    Long id;
	
//	@Column(name="street")
	String street;
	
//	@Column(name="city")
	String city;
	
	 @OneToOne(mappedBy = "address")
	 private User1 user1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User1 getUser1() {
		return user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

	public Address1(Long id, String street, String city, User1 user1) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.user1 = user1;
	}

	public Address1() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
