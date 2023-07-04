package com.spring.security.test.SpringSecurityTest.controllers;

import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/home","/"})
public class HomeControllers 
{
	//@PreAuthorize("hasRole('normal')")
	@GetMapping({"","/normal"})
	public ResponseEntity<String> normalUser()
	{
		return ResponseEntity.ok("yes, I am normal User");
	}
	
	//@PreAuthorize("hasRole('admin')")
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser()
	{
		return ResponseEntity.ok("yes, I am admin User");
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> User()
	{
		return ResponseEntity.ok("yes, I am public User");
	}
}
