package com.join.usermanagementsystem1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User1 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 @Column(name = "user_id")
	 Long user_id;
	 
//	 @Column(name="user_name")
	 String user_name;
	 
//	 @Column(name="address_id")
	 int address_id;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "address_id")
	  private Address1 address1;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public Address1 getAddress1() {
		return address1;
	}

	public void setAddress1(Address1 address1) {
		this.address1 = address1;
	}

	public User1() {
		super();
		// TODO Auto-generated constructor stub
	}//

	
	
	public User1(Long user_id, String user_name, int address_id, Address1 address1) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.address_id = address_id;
		this.address1 = address1;
	}//Parameterized constructor
	 
}
