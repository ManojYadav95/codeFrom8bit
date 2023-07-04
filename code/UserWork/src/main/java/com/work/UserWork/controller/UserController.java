package com.work.UserWork.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.work.UserWork.Exception.FillDataException;
import com.work.UserWork.Exception.UserNotFoundException;
import com.work.UserWork.entity.User;
import com.work.UserWork.repository.UserRepository;

@RestController
@RequestMapping("/home")
public class UserController 
{
	@Autowired
	UserRepository urepo;
	
	@PostMapping("/user/saveAll")
	public ResponseEntity<String> saveData(@RequestBody List<User> list)
	{
		for(int i =0;i<list.size();i++)
		{
			User user = list.get(i);
			if(user.getUsername().isEmpty() || user.getRole().isEmpty() || user.getTodaywork().isEmpty() || user.getWorkdone().isEmpty())
				throw new FillDataException();
		}
			urepo.saveAll(list);
			return ResponseEntity.ok("Data Saved in db.");
	}
	
	@PostMapping("/user/save")
	public ResponseEntity<String> saveData1(@RequestBody User user)
	{
		if(user.getUsername().isEmpty() || user.getRole().isEmpty() || user.getTodaywork().isEmpty() || user.getWorkdone().isEmpty())
			throw new FillDataException();
		else
		{
			urepo.save(user);
			return ResponseEntity.ok("Data Saved in db.");
		}
	}
	
	@GetMapping("/user/getAll")
	public List<User> getData()
	{
		List<User> list = urepo.findAll();
		if(list.isEmpty() == true)
			throw new UserNotFoundException();
		return list;
	}
	
	@GetMapping("/user/getByUsername")
	public User getUser(@RequestParam String username)
	{
		User user = urepo.findByUsername(username);
		if(user == null)
			throw new UserNotFoundException();
		return user;
	}
	
	@GetMapping("/user/getById")
	public Optional<User> getUser1(@RequestParam Long id)
	{
		Optional<User> user = urepo.findById(id);
		if(user == null)
			throw new UserNotFoundException();
		return user;
	}
	
	@GetMapping("/user/getByRole")
	public List<User> getUser2(@RequestParam String role)
	{
		List<User> list = urepo.findByRole(role);
		if(list.isEmpty() == true)
			throw new UserNotFoundException();
		return list;
	}
	
	@DeleteMapping("/user/deleteByUsername")
	public ResponseEntity<String> deleteUser(@RequestParam String username)
	{
		User user = urepo.findByUsername(username);
		if(user == null)
			throw new UserNotFoundException();
		else
		{
			urepo.delete(user);
			return ResponseEntity.ok("Deleted " + username + " record successfully" );
		}
	}
	
	@DeleteMapping("/user/deleteByRole")
	public ResponseEntity<String> deleteUser1(@RequestParam String role)
	{
		List<User> list = urepo.findByRole(role);
		if(list.isEmpty() == true)
			throw new UserNotFoundException();
		else
		{
			urepo.deleteAll(list);
			return ResponseEntity.ok("Record deleted successfully");
		}
	}
	
	@PutMapping("/user/updateOnlyUsername")
	public ResponseEntity<String> updateUser(@RequestParam String oldusername, @RequestParam String newusername) 
	{
		User user = urepo.findByUsername(oldusername);
		if(user == null)
			throw new UserNotFoundException();
		else
		{
			user.setUsername(newusername);
			urepo.save(user);
			return ResponseEntity.ok("Username " + oldusername + " in Database " + "is update with new name " + newusername);
		}
	}
	
	@PutMapping("/user/updateOnlyRole")
	public ResponseEntity<String> updateUser1(@RequestParam String oldrole, @RequestParam String newrole)
	{
		List<User> list = urepo.findByRole(oldrole);
		if((list.isEmpty()) == true)
			throw new UserNotFoundException();
		else
		{
			Iterator<User> iter = list.iterator();
			while(iter.hasNext())
			{
				User user = (User)iter.next();
				user.setRole(newrole);
			}
			urepo.saveAll(list);
			return ResponseEntity.ok("Record updated successfully");
		}
	}
}
