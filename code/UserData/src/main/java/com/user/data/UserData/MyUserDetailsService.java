package com.user.data.UserData;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = userrepository.findByUsername(username);
		if(user==null) 
			{
				throw new UsernameNotFoundException("user not found");
			}
			else
			{
				return new org.springframework.security.core.userdetails.User(user.getUsername(), 
						user.getPassword(), new ArrayList<>());
			}
			 
	}
	
}
