package com.user.data.UserData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserRepository urepo;
	
	@GetMapping("/getdata")
	public List<User> getUserList()
	{
		List<User> list=urepo.findAll();
		return list;
	}
}
