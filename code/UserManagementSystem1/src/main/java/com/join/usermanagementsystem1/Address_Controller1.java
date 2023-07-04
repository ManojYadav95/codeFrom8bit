package com.join.usermanagementsystem1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class Address_Controller1 
{
	@Autowired
	Address_Repo1 addressrepo1;
	
	@PostMapping("/post")
	public void addressData(@RequestBody Address1 adrs)
	{
		addressrepo1.save(adrs);
	}

}
