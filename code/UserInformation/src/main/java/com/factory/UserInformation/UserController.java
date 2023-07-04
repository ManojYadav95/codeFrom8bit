package com.factory.UserInformation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UserController 
{
	Role role1 = new Role();	Role role2 = new Role();	Role role3 = new Role();
	Group1 group1 = new Group1();	Group1 group2 = new Group1();	Group1 group3 = new Group1();	Group1 group4 = new Group1();
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private RoleRepository rrepo;
	
	@Autowired
	private  Group1Repository grepo;
	
	@PostMapping("/role1/save")
	public ResponseEntity<String> saveRole1(@RequestBody Role role)
	{
		role1 = role;
		role1 = rrepo.save(role1);
		System.out.print(role1);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/role2/save")
	public ResponseEntity<String> saveRole2(@RequestBody Role role)
	{
		role2 = role;
		role2 = rrepo.save(role2);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/role3/save")
	public ResponseEntity<String> saveRole3(@RequestBody Role role)
	{
		role3 = role;
		role3 = rrepo.save(role3);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/group1/save")
	public ResponseEntity<String> saveGroup1(@RequestBody Group1 group11)
	{
		group1 = group11;
		group1 = grepo.save(group1);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/group2/save")
	public ResponseEntity<String> saveGroup2(@RequestBody Group1 group11)
	{
		group2 = group11;
		group2 = grepo.save(group2);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/group3/save")
	public ResponseEntity<String> saveGroup3(@RequestBody Group1 group11)
	{
		group3 = group11;
		group3 = grepo.save(group3);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/group4/save")
	public ResponseEntity<String> saveGroup4(@RequestBody Group1 group11)
	{
		group4 = group11;
		group4 = grepo.save(group4);
		return ResponseEntity.ok("Data Saved");
	}
	
	@PostMapping("/user1/save")
	public ResponseEntity<User> saveData1(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role1);
		user.setGroup1(group1);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user2/save")
	public ResponseEntity<User> saveData2(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role1);
		user.setGroup1(group2);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user3/save")
	public ResponseEntity<User> saveData3(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role1);
		user.setGroup1(group3);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user4/save")
	public ResponseEntity<User> saveData4(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role1);
		user.setGroup1(group4);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user5/save")
	public ResponseEntity<User> saveData5(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role2);
		user.setGroup1(group1);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user6/save")
	public ResponseEntity<User> saveData6(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role2);
		user.setGroup1(group2);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user7/save")
	public ResponseEntity<User> saveData7(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role2);
		user.setGroup1(group3);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user8/save")
	public ResponseEntity<User> saveData8(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role2);
		user.setGroup1(group4);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user9/save")
	public ResponseEntity<User> saveData9(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role3);
		user.setGroup1(group1);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user10/save")
	public ResponseEntity<User> saveData10(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role3);
		user.setGroup1(group2);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user11/save")
	public ResponseEntity<User> saveData11(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role3);
		user.setGroup1(group3);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/user12/save")
	public ResponseEntity<User> saveData12(@RequestBody UserRequest req) 
	{	
		User user = new User(req);
		user.setRole(role3);
		user.setGroup1(group4);
		
		user = urepo.save(user);
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/admin")
	public List<User> getUserList()
	{
		List<User>list = urepo.findAll();
		return list;
	}
	
	@GetMapping("/manager")
	public List<User> getEmployeeByRole()
	{
		String role = "Employee";
		Role role1 = rrepo.findByRoles(role);
		List<User> list = urepo.findByRole(role1);
		return list;
	}
	
	@GetMapping("/employee")
	public User getEmployee(@RequestParam String username) throws Exception
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		if(currentPrincipalName.equals(username)) 
		{
			User user =urepo.findByUsername(username);
			return user;
		} 
		else 
			throw new Exception("User cann't access another user details.");
	}
	
	@GetMapping("/role/get")
	public List<Role> getRoleList()
	{
		List<Role>list = rrepo.findAll();
		return list;
	}
	
//	@PostMapping("/user/save")
//	public ResponseEntity<String> saveData(@RequestBody List<User> userdata)
//	{
//		urepo.saveAll(userdata);
//		return ResponseEntity.ok("Data Saved");
//	}
}
