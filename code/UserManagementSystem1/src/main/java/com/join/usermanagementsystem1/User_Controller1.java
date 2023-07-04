package com.join.usermanagementsystem1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class User_Controller1 
{
	@Autowired
	User_Repo1 userrepo1;
	
	@PostMapping("/post")
	public void userData(@RequestBody User1 user)
	{
		
		userrepo1.save(user);
	}
}
