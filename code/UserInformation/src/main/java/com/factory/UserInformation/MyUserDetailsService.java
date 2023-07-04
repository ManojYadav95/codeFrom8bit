package com.factory.UserInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService 
{
	@Autowired
	UserRepository urepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = urepo.findByUsername(username);
		if(user==null) 
		{
			throw new UsernameNotFoundException("user not found");
		}
		else
			return new MyUserDetails(user);
	}
}
